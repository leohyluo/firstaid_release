package com.iebm.aid.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.controller.req.BasicInfoReq;
import com.iebm.aid.controller.req.QueryPlanParam;
import com.iebm.aid.pojo.Plan;
import com.iebm.aid.pojo.vo.PlanVo;
import com.iebm.aid.pojo.vo.TokenVo;
import com.iebm.aid.service.AidRecordService;
import com.iebm.aid.service.PlanService;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(description="处置预案")
@RestController
@RequestMapping("/app/plan")
public class PlanController {
	
	@Resource
	private PlanService planService;
	@Resource
	private AidRecordService aidRecordService;

	@ApiIgnore
	@RequestMapping(value = "/decryptAll")
	public String decryptAll() {
		planService.decryptAll();		
		return "table table_plan decode completed.";
	}
	
	@ApiIgnore
	@ApiOperation(value = "生成拼音", notes = "生成拼音")
	@GetMapping(value = "/genPinyin")
	public String genPinyin() {
		//planService.genPinyin();
		return "success";
	}
	
	@ApiOperation(value="获取紧急预案", notes="获取紧急预案", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/queryGravePlan")
	public ResponseMessage queryGravePlan(@RequestBody BasicInfoReq basicInfo, HttpServletRequest request) {
		TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
		List<PlanVo> planList = planService.queryGravePlan();
		aidRecordService.saveAidRecord(basicInfo, planList, tokenVo);
		return WebUtils.buildSuccessResponseMessage(planList);
	}
	
	@ApiOperation(value = "查看预案详情", notes="查看预案详细信息", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "客户端token", required = true, dataType = "String", paramType = "header")
	})
	@PostMapping(value = "/queryById")
	public ResponseMessage queryById(@RequestBody QueryPlanParam param) {
		String planId = param.getPlanId();
		Plan plan = planService.findByPlanId(planId);
		PlanVo planVo = new PlanVo(plan);
		return WebUtils.buildSuccessResponseMessage(planVo);
	}
}
