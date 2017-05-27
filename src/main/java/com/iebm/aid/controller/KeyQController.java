package com.iebm.aid.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.service.KeyQService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/app/keyq")
public class KeyQController {
	
	@Resource
	private KeyQService keyQService;

	@ApiIgnore
	@RequestMapping(value = "/decryptAll")
	public String decryptAll() {
		keyQService.decryptAll();		
		return "table table_keyq decode completed.";
	}
}
