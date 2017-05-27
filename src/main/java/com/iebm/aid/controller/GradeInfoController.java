package com.iebm.aid.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.service.GradeInfoService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/app/gradeInfo")
public class GradeInfoController {
	
	@Resource
	private GradeInfoService gradeInfoService;

	@ApiIgnore
	@RequestMapping(value = "/decryptAll")
	public String decryptAll() {
		gradeInfoService.decryptAll();		
		return "table table_gradeinfo decode completed.";
	}
}
