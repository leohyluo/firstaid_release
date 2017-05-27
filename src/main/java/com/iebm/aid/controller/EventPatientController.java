package com.iebm.aid.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.pojo.EventPatient;
import com.iebm.aid.service.EventPatientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Api(description="患者信息")
@RestController
@RequestMapping("/app/patient")
public class EventPatientController {
	
	@Resource
	private EventPatientService eventPatientService;

	@ApiOperation(value="查询患者", notes="根据事件编号查询患者列表")
	@PostMapping(value = "/query")
	public List<EventPatient> query(@RequestParam @ApiParam(required = true, value="token") String token,
			@RequestParam @ApiParam(required = true, value = "事件编号") String eventNo) {
		return eventPatientService.findByEventNo(eventNo);
	}
}
