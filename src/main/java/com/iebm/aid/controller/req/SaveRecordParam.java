package com.iebm.aid.controller.req;

import com.iebm.aid.pojo.AidFiles;
import com.iebm.aid.pojo.AidRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("保存诊断记录实体")
public class SaveRecordParam {

	@ApiModelProperty("患者档案")
	private AidFiles patientFiles;
	@ApiModelProperty("诊断记录")
	private AidRecord aidRecord;
	
	public AidFiles getPatientFiles() {
		return patientFiles;
	}
	public void setPatientFiles(AidFiles patientFiles) {
		this.patientFiles = patientFiles;
	}
	public AidRecord getAidRecord() {
		return aidRecord;
	}
	public void setAidRecord(AidRecord aidRecord) {
		this.aidRecord = aidRecord;
	}	
}
