package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查看急危重症疾病详情实体")
public class SpecDiseaseParam3 {

	@ApiModelProperty("疾病id")
	private String disId;

	public String getDisId() {
		return disId;
	}

	public void setDisId(String disId) {
		this.disId = disId;
	}
	
	
}
