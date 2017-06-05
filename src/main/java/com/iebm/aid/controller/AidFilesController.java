package com.iebm.aid.controller;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.controller.req.SearchAidFilesParam;
import com.iebm.aid.controller.req.SearchRecordDetailParam;
import com.iebm.aid.pojo.AidFiles;
import com.iebm.aid.pojo.vo.AidRecordDetailVo;
import com.iebm.aid.pojo.vo.AidRecordVo;
import com.iebm.aid.service.AidFilesService;
import com.iebm.aid.service.AidRecordService;
import com.iebm.aid.utils.StringUtils;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.ResponseStatus;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="急救档案")
@RestController
@RequestMapping("/app/aidFiles")
public class AidFilesController {
	
	@Resource
	private AidFilesService aidFilesService;
	@Resource
	private AidRecordService aidRecordService;

	@ApiOperation(value = "完善急救档案", notes="完善急救档案", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value="客户端token", required = true, dataType = "String", paramType="header")
	})
	@PostMapping(value = "/save")
	public ResponseMessage save(@RequestBody AidFiles aidFile) {
		if(aidFile.getId() == null || aidFile.getId().longValue() == 0) {
			return WebUtils.buildResponseMessage(ResponseStatus.REQUIRED_PARAMETER_MISSING);
		}
		aidFile.setLastupdTime(LocalDateTime.now());
		aidFilesService.save(aidFile);
		return WebUtils.buildSuccessResponseMessage();
	}
	
	@ApiOperation(value = "查看急救档案", notes = "查看急救档案", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "客户端token", required = true, dataType = "String", paramType = "header")
	})
	@PostMapping(value = "/search")
	public ResponseMessage search(@RequestBody SearchAidFilesParam param) {
		Page<AidRecordVo> page = aidRecordService.findByPage(param);
		return WebUtils.buildSuccessResponseMessage(page);
	}
	
	@ApiOperation(value = "查看急救记录详情", notes="查看急救记录详情", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "客户端token", required = true, dataType = "String", paramType = "header")
	})
	@PostMapping("/getDetail")
	public ResponseMessage getDetail(@RequestBody SearchRecordDetailParam param) {
		String id = param.getId();
		if(StringUtils.isEmpty(id)) {
			return WebUtils.buildResponseMessage(ResponseStatus.REQUIRED_PARAMETER_MISSING);
		}
		AidRecordDetailVo detailVo = aidRecordService.getDetail(id);
		return WebUtils.buildSuccessResponseMessage(detailVo);
	}
}
