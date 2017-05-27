package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("通过问诊获取预案实体")
public class SmartPlanParam {

	@ApiModelProperty("服务端任务编号")
	private String serverId;

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
}
