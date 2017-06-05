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
	@ApiModelProperty("上/下一个问题,prev/next")
	private String type;
	@ApiModelProperty("所有问题id集合,以逗号分隔")
	private String allKqIds;
	@ApiModelProperty("所有答案id集合,以逗号分隔")
	private String allAnswerIds;
	@ApiModelProperty("自填项,以逗号分隔[当前问题无自填项或自填项为空时用0表示]")
	private String allTexts;
	
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
	public String getAllKqIds() {
		return allKqIds;
	}
	public void setAllKqIds(String allKqIds) {
		this.allKqIds = allKqIds;
	}
	public String getAllAnswerIds() {
		return allAnswerIds;
	}
	public void setAllAnswerIds(String allAnswerIds) {
		this.allAnswerIds = allAnswerIds;
	}
	public String getAllTexts() {
		return allTexts;
	}
	public void setAllTexts(String allTexts) {
		this.allTexts = allTexts;
	}
	
}
