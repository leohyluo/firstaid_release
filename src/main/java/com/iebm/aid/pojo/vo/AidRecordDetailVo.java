package com.iebm.aid.pojo.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("急救记录详情实体")
public class AidRecordDetailVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("患者基本信息")
	private PatientInfo patientInfo;
	
	@ApiModelProperty("急诊记录")
	private EmengencyRecord emengencyRecord; 
	
	@ApiModelProperty("呼救记录")
	private CallRecord callRecord;
	
	public AidRecordDetailVo() {}
	
	public AidRecordDetailVo(PatientInfo patientInfo, EmengencyRecord emengencyRecord, CallRecord callRecord) {
		this.patientInfo =  patientInfo;
		this.emengencyRecord = emengencyRecord;
		this.callRecord = callRecord;
	}

	public PatientInfo getPatientInfo() {
		return patientInfo;
	}

	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}

	public EmengencyRecord getEmengencyRecord() {
		return emengencyRecord;
	}

	public void setEmengencyRecord(EmengencyRecord emengencyRecord) {
		this.emengencyRecord = emengencyRecord;
	}

	public CallRecord getCallRecord() {
		return callRecord;
	}

	public void setCallRecord(CallRecord callRecord) {
		this.callRecord = callRecord;
	}

}
