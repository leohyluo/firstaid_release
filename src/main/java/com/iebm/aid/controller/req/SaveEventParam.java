package com.iebm.aid.controller.req;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("事件实体")
public class SaveEventParam {

	@ApiModelProperty("事件信息")
	private EventParam eventInfo;
	@ApiModelProperty("患者信息")
	private List<PatientParam> patientInfo;
	
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
