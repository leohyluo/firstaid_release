package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("急救指南实体")
public class SearchGuideParam {

	@ApiModelProperty("急救指南三级目录名称")
	private String dir3;

	public String getDir3() {
		return dir3;
	}

	public void setDir3(String dir3) {
		this.dir3 = dir3;
	}
	
	
}
