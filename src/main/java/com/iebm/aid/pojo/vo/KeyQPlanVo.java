package com.iebm.aid.pojo.vo;

import com.iebm.aid.web.ResponseMessage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("问题或预案实体")
public class KeyQPlanVo {

	@ApiModelProperty("1:问题与答案 2:处置预案")
	private String type;
	@ApiModelProperty("数据体")
	private ResponseMessage body;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ResponseMessage getBody() {
		return body;
	}
	public void setBody(ResponseMessage body) {
		this.body = body;
	}
}
