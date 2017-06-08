package com.iebm.aid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/appTest")
	public String appTest() {
		return "application runing...";
	}
}
