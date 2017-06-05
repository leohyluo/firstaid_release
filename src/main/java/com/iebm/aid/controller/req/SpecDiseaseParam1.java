package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("根据大类id获取所有的急危重症实体")
public class SpecDiseaseParam1 {

	@ApiModelProperty("大类id")
	private String sysId;

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	
	
}
