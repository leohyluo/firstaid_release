package com.iebm.aid.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.common.DataPool;
import com.iebm.aid.controller.req.BasicInfoReq;
import com.iebm.aid.controller.req.KeyQParam;
import com.iebm.aid.controller.req.SmartPlanParam;
import com.iebm.aid.pojo.CacheKeyQ;
import com.iebm.aid.pojo.MainSymptom;
import com.iebm.aid.pojo.Mpds;
import com.iebm.aid.pojo.req.BasicKeyQ;
import com.iebm.aid.pojo.vo.KeyQVo;
import com.iebm.aid.pojo.vo.PlanVo;
import com.iebm.aid.pojo.vo.ResponseMessageVo;
import com.iebm.aid.pojo.vo.ResponseMessageVo2;
import com.iebm.aid.service.AidRecordService;
import com.iebm.aid.service.CacheKeyQService;
import com.iebm.aid.service.KeyQService;
import com.iebm.aid.service.MainSymptomService;
import com.iebm.aid.service.MpdsService;
import com.iebm.aid.service.PlanService;
import com.iebm.aid.utils.CollectionUtils;
import com.iebm.aid.utils.StringUtils;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.ResponseStatus;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(description="急救决策支持")
@RestController
@RequestMapping("/app/main")
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(MainController.class);

	@Resource
	private MainSymptomService mainSymptomService;
	@Resource
	private KeyQService keyQService;
	@Resource
	private CacheKeyQService cacheKeyQService;
	@Resource
	private PlanService planService;
	@Resource
	private MpdsService mpdsService;
	@Resource
	private AidRecordService aidRecordService;
	
	@ApiOperation(value = "获取所有主诉", notes="获取所有主诉")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/findAllMainSymptom")
	public ResponseMessage findAllMainSymptom() {
		List<MainSymptom> list = mainSymptomService.findAll();
		return WebUtils.buildSuccessResponseMessage(list);
	}
	
	@ApiOperation(value = "获取第一个问题", notes = "获取第一个问题", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/getFirstQues")
	public ResponseMessageVo getFirstQues(@RequestBody BasicInfoReq basicInfo) {
		String serverId = String.valueOf(System.currentTimeMillis());
		DataPool.put(serverId, basicInfo);
		
		List<KeyQVo> keyQList = cacheKeyQService.getFirstKeyQ(basicInfo, serverId);		
		ResponseMessageVo vo = new ResponseMessageVo(serverId, keyQList);
		return vo;
	}
	
	@ApiOperation(value = "获取问题与答案", notes = "获取问题与答案", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/searchQues")
	public ResponseMessageVo2 searchQues(@RequestBody KeyQParam param) {
		String type = "1";
		List<KeyQVo> keyqList = keyQService.searchKeyQ(param);
		List<PlanVo> planList = null;
		Mpds mpds = null;
		if(CollectionUtils.isEmpty(keyqList)) {
			type = "2";
			String serverId = param.getServerId();
			planList = planService.queryByServerId(serverId);
			CacheKeyQ cacheKeyq = cacheKeyQService.findByServerId(serverId);
			mpds = mpdsService.findMpdsGrade(cacheKeyq);
			//保存诊断记录
			aidRecordService.saveAidRecord(serverId, planList);
			//cacheKeyQService.delete(cacheKeyq);
		}
		
		return new ResponseMessageVo2(type, keyqList, planList, mpds);
	}
	
	@ApiIgnore
	@ApiOperation(value = "获取问题个数", notes="获取主诉问题的数量")
	@PostMapping(value = "/getQuestionCount/{mainId}")
	public int getQuestionCount(@PathVariable String mainId) {
		return keyQService.getQuestionLen(mainId);
	}
	
	@ApiIgnore
	@ApiOperation(value = "查询问题与答案(初稿)", notes="根据主症状查看具体的问题与答案")
	@PostMapping(value = "/findQuesAndAnswerOriginal/{mainId}/{curQuesNo}")
	public List<KeyQVo> findQuesAndAnswerOriginal(@PathVariable String mainId, @PathVariable(name="curQuesNo") Integer curQuesNo,
			@RequestParam(required = false) @ApiParam(required = false) String answerId) {
		return keyQService.questionAndAnswer(mainId, curQuesNo, answerId);
	}
	
	@ApiIgnore
	@ApiOperation(value = "查询问题与答案", notes="根据主症状查看具体的问题与答案")
	@PostMapping(value = "/findQuesAndAnswer/{mainId}/{curQuesNo}")
	public List<KeyQVo> findQuesAndAnswer(@PathVariable String mainId, @PathVariable(name="curQuesNo") Integer curQuesNo, @ApiParam(required = false) @RequestBody BasicKeyQ basicKeyq) {
		return keyQService.next(mainId, curQuesNo, basicKeyq);
	}
	
	@ApiIgnore
	@ApiOperation(value = "获取处置预案", notes="根据回答的问题获取处置预案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "客户端token", required = true, dataType = "String", paramType = "header")
	})
	@PostMapping("/getPlan")
	public ResponseMessage getPlan(@RequestBody SmartPlanParam param) {
		String serverId = param.getServerId();
		if(StringUtils.isEmpty(serverId)) {
			return WebUtils.buildResponseMessage(ResponseStatus.REQUIRED_PARAMETER_MISSING);
		}
		List<PlanVo> voList = planService.queryByServerId(serverId);
		return WebUtils.buildSuccessResponseMessage(voList);
	}
}
