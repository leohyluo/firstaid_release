package com.iebm.aid.controller.req.third;

import java.util.List;

import com.iebm.aid.controller.req.EventParam;
import com.iebm.aid.controller.req.PatientParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("120登录参数")
public class LoginParam {

	@ApiModelProperty("医院编码")
	private String hospitalCode;
	@ApiModelProperty("用户名")
	private String userName;
	@ApiModelProperty("事件信息")
	private EventParam eventInfo;
	@ApiModelProperty("患者列表")
	private List<PatientParam> patientInfo;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public EventParam getEventInfo() {
		return eventInfo;
	}
	public void setEventInfo(EventParam eventInfo) {
		this.eventInfo = eventInfo;
	}
	public List<PatientParam> getPatientInfo() {
		return patientInfo;
	}
	public void setPatientInfo(List<PatientParam> patientInfo) {
		this.patientInfo = patientInfo;
	}
	
}
