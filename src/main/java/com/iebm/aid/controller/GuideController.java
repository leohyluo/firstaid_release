package com.iebm.aid.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.controller.req.SearchGuideParam;
import com.iebm.aid.pojo.Guide;
import com.iebm.aid.service.GuideService;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="GuideController",description="急救指南")
@RestController
@RequestMapping("/app/guide")
public class GuideController {
	
	@Resource
	private GuideService guideService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@ApiIgnore
	@RequestMapping(value = "/decryptAll")
	public String decryptAll() {
		guideService.decryptAll();		
		return "table table_guide decode completed.";
	}
	
	@ApiOperation(value = "急救指南首页", notes = "急救指南")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/list")
	public ResponseMessage list() {
		List<String> list = guideService.findDir3();
		logger.info("list.size = " + list.size());
		return WebUtils.buildSuccessResponseMessage(list);
	}
	
	@ApiOperation(value="根据名称查询急救指南详情", notes="根据名称查询急救指南详情")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/findByDir3")
	public ResponseMessage findByDir3(@RequestBody SearchGuideParam param) {
		String dir3 = param.getDir3();
		List<Guide> guideList = guideService.findByDir3(dir3);
		return WebUtils.buildSuccessResponseMessage(guideList);
	}
}
