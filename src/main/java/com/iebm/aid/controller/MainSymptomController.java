package com.iebm.aid.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.service.MainSymptomService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/app/mainSymptom")
public class MainSymptomController {
	
	@Resource
	private MainSymptomService mainSymptomService;

	@ApiIgnore
	@RequestMapping(value = "/decryptAll")
	public String decryptAll() {
		mainSymptomService.decryptAll();		
		return "table table_mainsymp decode completed.";
	}
}
