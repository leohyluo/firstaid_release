package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("急救记录查询数据载体")
public class QueryRecordParam {

	@ApiModelProperty("事件编号")
	private String eventNo;

	public String getEventNo() {
		return eventNo;
	}

	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}
	
	
}
