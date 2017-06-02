package com.iebm.aid.pojo.vo;

import java.util.List;

import com.iebm.aid.web.ResponseStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("第一个问题答案实体")
public class ResponseMessageVo {

	@ApiModelProperty("状态码")
	private int code;
	
	@ApiModelProperty("数据")
	private FirstQuesPojo data;
	
	@ApiModelProperty("备注")
	private String msg;
	
	public ResponseMessageVo(String serverId, List<KeyQVo> keyqList) {
		this.code = ResponseStatus.SUCCESS.code();
		this.data = new FirstQuesPojo(serverId, keyqList);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public FirstQuesPojo getData() {
		return data;
	}

	public void setData(FirstQuesPojo data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

class FirstQuesPojo {
	private String serverId;
	private List<KeyQVo> keyqList;
	
	public FirstQuesPojo(String serverId, List<KeyQVo> keyqList) {
		this.serverId = serverId;
		this.keyqList = keyqList;
	}
	
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public List<KeyQVo> getKeyqList() {
		return keyqList;
	}
	public void setKeyqList(List<KeyQVo> keyqList) {
		this.keyqList = keyqList;
	}
}
