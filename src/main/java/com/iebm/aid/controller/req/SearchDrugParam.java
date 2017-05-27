package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SearchDrugParam {

	@ApiModelProperty("关键字")
	private String keyword;
	@ApiModelProperty("药品大类名称")
	private String name;
	@ApiModelProperty("药品名称")
	private String drugName;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	
	
}
