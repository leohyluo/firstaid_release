package com.iebm.aid.pojo.vo;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.pojo.KeyQ;

public class KeyQVo {

	private Integer kqID;
	private String kqTitle;
	private String answer;
	private String answerId;
	private String kqType;
	
	public KeyQVo(KeyQ obj) {
		BeanUtils.copyProperties(obj, this);
	}
	
	public String getKqTitle() {
		return kqTitle;
	}
	public void setKqTitle(String kqTitle) {
		this.kqTitle = kqTitle;
	}
	public String getAnswer() {
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
	
}
