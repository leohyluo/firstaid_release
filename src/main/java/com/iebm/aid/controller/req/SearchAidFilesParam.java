package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询急救档案实体")
public class SearchAidFilesParam extends PageParam {

	@ApiModelProperty("1：当天 2:一周 3:一月 4:自定义 5:所有")
	private String type;
	
	@ApiModelProperty("当type为4时必填,yyyy-MM-dd")
	private String startTime;
	
	@ApiModelProperty("当type为4时必填,yyyy-MM-dd")
	private String endTime;
		
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
