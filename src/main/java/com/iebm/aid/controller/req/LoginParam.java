package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("登录参数")
public class LoginParam {

	//private String hospitalCode;
	@ApiModelProperty("用户名")
	private String userName;
	@ApiModelProperty("密码")
	private String password;
	//private EventParam eventInfo;
	//private List<PatientParam> patientInfo;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
