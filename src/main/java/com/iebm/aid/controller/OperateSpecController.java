package com.iebm.aid.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.controller.req.OperateSpecParam;
import com.iebm.aid.pojo.vo.OperateSpecVo;
import com.iebm.aid.service.OperateSpecService;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(description="操作规范")
@RestController
@RequestMapping("/app/operateSpec")
public class OperateSpecController {
	
	@Resource
	private OperateSpecService operateSpecService;

	@ApiIgnore
	@RequestMapping(value = "/decryptAll")
	public String decryptAll() {
		//operateSpecService.decryptAll();		
		return "table table_operatspec decode completed.";
	}
	
	@ApiOperation(value = "操作规范大类列表", notes="操作规范大类列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/list")
	public ResponseMessage list(){
		List<String> list = operateSpecService.groupByDir2();
		return WebUtils.buildSuccessResponseMessage(list);
	}
	
	
	@ApiOperation(value = "查看操作规范", notes="查看操作规范", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/findByDir2")
	public ResponseMessage findByDir2(@RequestBody OperateSpecParam param){
		String name = param.getName();
		List<OperateSpecVo> voList = operateSpecService.findByDir2(name);
		return WebUtils.buildSuccessResponseMessage(voList);
	}
}
