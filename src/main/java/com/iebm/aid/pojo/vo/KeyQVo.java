package com.iebm.aid.pojo.vo;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.common.GlobalConstants;
import com.iebm.aid.pojo.KeyQ;
import com.iebm.aid.utils.EBMEnDecrypt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("问题答案实体")
public class KeyQVo {

	@ApiModelProperty("问题id")
	private Integer kqID;
	
	@ApiModelProperty("问题内容")
	private String kqTitle;
	
	@ApiModelProperty("答案内容")
	private String answer;
	
	@ApiModelProperty("答案id")
	private String answerId;
	
	@ApiModelProperty("问题类型,1表示需添加备注的问题")
	private String kqType;
	
	@ApiModelProperty("引申问题id")
	private String forwardId;
	
	public KeyQVo(KeyQ obj) {
		BeanUtils.copyProperties(obj, this);
	}
	
	public String getKqTitle() {
		kqTitle = EBMEnDecrypt.decrypt(kqTitle, GlobalConstants.DECRYPT_CHARSET);
		return kqTitle;
	}
	public void setKqTitle(String kqTitle) {
		this.kqTitle = kqTitle;
	}
	public String getAnswer() {
		answer = EBMEnDecrypt.decrypt(answer, GlobalConstants.DECRYPT_CHARSET);
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public Integer getKqID() {
		return kqID;
	}

	public void setKqID(Integer kqID) {
		this.kqID = kqID;
	}

	public String getKqType() {
		return kqType;
	}

	public void setKqType(String kqType) {
		this.kqType = kqType;
	}

	public String getForwardId() {
		return forwardId;
	}

	public void setForwardId(String forwardId) {
		this.forwardId = forwardId;
	}
	
}
