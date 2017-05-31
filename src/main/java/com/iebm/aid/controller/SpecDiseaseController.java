package com.iebm.aid.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.controller.req.SpecDiseaseParam;
import com.iebm.aid.pojo.SpecDisease;
import com.iebm.aid.pojo.SysDisease;
import com.iebm.aid.pojo.vo.SpecDiseaseVo;
import com.iebm.aid.service.SpecDiseaseService;
import com.iebm.aid.service.SysDiseaseService;
import com.iebm.aid.utils.StringUtils;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.ResponseStatus;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(description="急危重症")
@RestController
@RequestMapping("/app/specDisease")
public class SpecDiseaseController {
	
	@Resource
	private SpecDiseaseService specDiseaseService;
	@Resource
	private SysDiseaseService sysDiseaseService;

	@ApiIgnore
	@RequestMapping(value = "/decryptAll")
	public String decryptAll() {
		specDiseaseService.decryptAll();		
		return "table table_specDisease decode completed.";
	}
	
	@ApiIgnore
	@ApiOperation(value = "生成拼音", notes="生成拼音")
	@GetMapping(value = "genPinyin")
	public String genPinyin() {
		specDiseaseService.genPinyin();
		return "success";
	}
	
	@ApiOperation(value = "获取所有急危重症大类", notes="急危重症大类列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/list")
	public ResponseMessage list() {
		List<SysDisease> list = sysDiseaseService.findAll();
		return WebUtils.buildSuccessResponseMessage(list);
	}
	
	@ApiOperation(value = "根据大类id获取所有的急危重症")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/findById")
	public ResponseMessage findById(@RequestBody SpecDiseaseParam param) {
		String sysId = param.getSysId();
		if(StringUtils.isEmpty(sysId)) {
			return WebUtils.buildResponseMessage(ResponseStatus.REQUIRED_PARAMETER_MISSING);
		}
		List<SpecDiseaseVo> list = specDiseaseService.findVoBySysId(sysId);
		return WebUtils.buildSuccessResponseMessage(list);
	}
	
	@ApiOperation(value="根据关键字查询", notes="根据拼音简码或疾病名称查询疾病列表", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/findByKeyword")
	public ResponseMessage findByKeyword(@RequestBody SpecDiseaseParam param) {
		String keyword = param.getKeyword();
		List<SpecDiseaseVo> list = specDiseaseService.findVoByKeyword(keyword);
		return WebUtils.buildSuccessResponseMessage(list);
	}
	
	@ApiOperation(value = "根据疾病id获取急危重症疾病详情", notes="根据疾病id获取急危重症疾病详情", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value="/getDetail")
	public ResponseMessage getDetail(@RequestBody SpecDiseaseParam param) {
		String disId = param.getDisId();
		if(StringUtils.isEmpty(disId)) {
			return WebUtils.buildResponseMessage(ResponseStatus.REQUIRED_PARAMETER_MISSING);
		}
		SpecDisease spec = specDiseaseService.get(Long.valueOf(disId));
		return WebUtils.buildSuccessResponseMessage(spec);
	}
}
