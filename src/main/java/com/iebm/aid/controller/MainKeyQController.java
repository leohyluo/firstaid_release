package com.iebm.aid.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.service.MainKeyQService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/app/mainKeyQ")
public class MainKeyQController {

	@Resource
	private MainKeyQService mainKeyQService;
	
	
	@ApiIgnore
	@RequestMapping(value = "/decryptAll")
	public String decryptAll() {
		mainKeyQService.decryptAll();		
		return "table table_mainkeyq completed.";
	}
}
