package com.iebm.aid.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("报案信息")
public class BasicKeyQ {

	@ApiModelProperty("呼叫类型")
	private String callType;
	
	@ApiModelProperty("是否和患者一起")
	private String withPatient;	
	
	@ApiModelProperty("患者年龄")
	private String age;	
	
	@ApiModelProperty("患者性别")
	private String gender;
	
	@ApiModelProperty("是否有意识")
	private String hasAware;
	
	@ApiModelProperty("是否有呼吸")
	private String hasBreath;
	
	@ApiModelProperty("答案id")
	private String answerId;
	
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public String getWithPatient() {
		return withPatient;
	}
	public void setWithPatient(String withPatient) {
		this.withPatient = withPatient;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHasAware() {
		return hasAware;
	}
	public void setHasAware(String hasAware) {
		this.hasAware = hasAware;
	}
	public String getHasBreath() {
		return hasBreath;
	}
	public void setHasBreath(String hasBreath) {
		this.hasBreath = hasBreath;
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	
	
}
