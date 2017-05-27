package com.iebm.aid.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.controller.req.SaveEventParam;
import com.iebm.aid.pojo.EventRecord;
import com.iebm.aid.pojo.User;
import com.iebm.aid.pojo.vo.TokenVo;
import com.iebm.aid.service.EventRecordService;
import com.iebm.aid.service.UserService;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Api(description="急救记录")
@RestController
@RequestMapping("/app/record")
public class EventRecordController {
	
	@Resource
	private EventRecordService eventRecordService;
	@Resource
	private UserService userService;

	@PostMapping(value = "/query")
	@ApiOperation(value = "查询急救记录", notes = "查询急救记录", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value="访问token", dataType="String", paramType="query"),
		@ApiImplicitParam(name = "eventNo", value="事件编号", dataType="String", paramType="query")
	})
	public List<EventRecord> query(String token, String eventNo) {
		List<EventRecord> list = eventRecordService.findByEventNo(eventNo);
		return list;
	}
	
	@PostMapping(value = "/save")
	@ApiOperation(value = "保存急救事件", notes = "保存急救事件", produces = "application/json")
	public ResponseMessage save(@RequestBody @ApiParam("事件实体") SaveEventParam param, 
			@RequestHeader("token") String token, HttpServletRequest request) {
		if(param.getEventInfo() != null) {
			TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
			String userId = tokenVo.getUserId();
			User user = userService.get(Long.valueOf(userId)); 
			eventRecordService.saveEventInfo(user, param.getEventInfo(), param.getPatientInfo());
		}
//		System.out.println(1/0);
		return WebUtils.buildSuccessResponseMessage();
	}
}
