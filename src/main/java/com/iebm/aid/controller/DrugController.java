package com.iebm.aid.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.controller.req.SearchDrugParam;
import com.iebm.aid.pojo.Drug;
import com.iebm.aid.service.DrugService;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(description="急救药品")
@RestController
@RequestMapping("/app/drug")
public class DrugController {
	
	@Resource
	private DrugService drugService;

	@ApiIgnore
	@RequestMapping(value = "/decryptAll")
	public String decryptAll() {
		//drugService.decryptAll();		
		return "table table_drugs decode completed.";
	}
	
	@ApiIgnore
	@ApiOperation(value = "生成拼音码", notes="为药品名称生成拼音码")
	@GetMapping(value = "/genPinyin")
	public String genPinyin() {
		drugService.genPinyin();
		return "success";
	}
	
	@ApiOperation(value = "急救药品大类列表", notes="急救药品大类列表", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/classlist")
	public ResponseMessage classlist() {
		List<String> list = drugService.findDrugClass();
		return WebUtils.buildSuccessResponseMessage(list);
	}
	
	@ApiOperation(value = "搜索药品", notes="根据药品名称或拼音搜索急救药品", produces="applicatioin/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/findByKeyword")
	public ResponseMessage findByKeyword(@RequestBody SearchDrugParam param) {
		String keyword = param.getKeyword();
		List<String> list = drugService.findByKeyword(keyword);
		return WebUtils.buildSuccessResponseMessage(list);
	}

	@ApiOperation(value = "查询子类药品", notes="根据大类名称搜索急救药品", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/findByName")
	public ResponseMessage findByName(@RequestBody SearchDrugParam param) {
		String name = param.getName();
		List<String> list = drugService.findByType0(name);
		return WebUtils.buildSuccessResponseMessage(list);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@ApiOperation(value = "查看药品详情", notes="根据药品名称查看药品详细信息", produces="application/json")
	@PostMapping(value = "/getDetail")
	public ResponseMessage getDetail(@RequestBody SearchDrugParam param){
		String drugName = param.getDrugName();
		Drug drug = drugService.findByName(drugName);
		return WebUtils.buildSuccessResponseMessage(drug);
	}
}
