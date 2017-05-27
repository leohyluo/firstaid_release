package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询问题实体")
public class KeyQParam {

	@ApiModelProperty("任务id")
	private String serverId;
	@ApiModelProperty("问题id")
	private String kqId;
	@ApiModelProperty("答案id")
	private String answerId;
	@ApiModelProperty("上/下一个问题")
	private String type;
	
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public String getKqId() {
		return kqId;
	}
	public void setKqId(String kqId) {
		this.kqId = kqId;
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
