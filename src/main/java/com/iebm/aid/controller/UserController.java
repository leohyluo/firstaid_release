package com.iebm.aid.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iebm.aid.controller.req.LoginParam;
import com.iebm.aid.controller.req.ModifyPwdParam;
import com.iebm.aid.pojo.User;
import com.iebm.aid.pojo.UserToken;
import com.iebm.aid.pojo.vo.TokenVo;
import com.iebm.aid.service.EventRecordService;
import com.iebm.aid.service.UserService;
import com.iebm.aid.service.UserTokenService;
import com.iebm.aid.utils.StringUtils;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.ResponseStatus;
import com.iebm.aid.web.WebUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="用户管理")
@RestController
@RequestMapping("/app/user")
public class UserController {
	
	@Resource
	private UserService userService;
	@Resource
	private UserTokenService userTokenService;
	@Resource
	private EventRecordService eventRecordService;

	@ApiOperation(value = "用户登录", notes="用户登录", produces="application/json")
	@PostMapping(value = "/login")
	public ResponseMessage login(@RequestBody LoginParam loginParam) {
		String userName = loginParam.getUserName();
		String password = loginParam.getPassword();
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
			return WebUtils.buildResponseMessage(ResponseStatus.REQUIRED_PARAMETER_MISSING);
		}
		User user = userService.findByPassword(userName, password);
		if(user == null) {
			return WebUtils.buildResponseMessage(ResponseStatus.USER_NOT_FOUND);
		}
		UserToken token = userTokenService.create(user);		
		ResponseMessage responseMessage = WebUtils.buildSuccessResponseMessage(token);
		return responseMessage;
	}
	
	@ApiOperation(value = "修改密码 ", notes="修改密码", produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="token", value="客户端token", required = true, dataType="String", paramType="header")
	})
	@PostMapping(value = "/modifyPwd")
	public ResponseMessage modifyPwd(@RequestBody ModifyPwdParam param,
			HttpServletRequest request) {
		String oldPassword = param.getOldPassword();
		String newPassword = param.getNewPassword();
		if(StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)) {
			return WebUtils.buildResponseMessage(ResponseStatus.REQUIRED_PARAMETER_MISSING);
		}
		TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
		if(tokenVo == null) {
			return WebUtils.buildResponseMessage(ResponseStatus.EXCEPTION);
		}
		Long userId = Long.valueOf(tokenVo.getUserId());
		User user = userService.get(userId);
		if(user == null) {
			return WebUtils.buildResponseMessage(ResponseStatus.USER_NOT_FOUND);
		}
		if(!user.getPassword().equals(oldPassword)) {
			return WebUtils.buildResponseMessage(ResponseStatus.OLD_PASSWORD_INCORRECT);
		}
		user.setPassword(newPassword);
		userService.save(user);
		return WebUtils.buildSuccessResponseMessage();
	}
}
