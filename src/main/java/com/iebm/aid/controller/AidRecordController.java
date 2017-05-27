package com.iebm.aid.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.controller.req.SaveRecordParam;
import com.iebm.aid.pojo.AidFiles;
import com.iebm.aid.service.AidRecordService;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Api(description="诊断记录")
@RestController
@RequestMapping("/app/aidRecord")
public class AidRecordController {
	
	@Resource
	private AidRecordService aidRecordService;

	@ApiOperation(value = "保存诊断记录", notes="保存诊断记录", produces="application/json")
	@PostMapping(value = "/save")
	public ResponseMessage save(@RequestBody SaveRecordParam param){
		//aidRecordService.saveAidRecord(param.getPatientFiles(), null);
		return WebUtils.buildSuccessResponseMessage();
	}
	
	@ApiOperation(value = "保存急救档案", notes="保存用户急救档案", produces="application/json")
	public ResponseMessage savePatientFiles(@RequestBody AidFiles aidFiles) {
		aidRecordService.saveAidFiles(aidFiles);
		return WebUtils.buildSuccessResponseMessage();
	}
}
