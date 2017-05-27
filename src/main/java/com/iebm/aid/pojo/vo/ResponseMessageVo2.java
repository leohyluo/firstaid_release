package com.iebm.aid.pojo.vo;

import java.util.List;

import com.iebm.aid.pojo.Mpds;
import com.iebm.aid.web.ResponseStatus;

import io.swagger.annotations.ApiModel;

@ApiModel("问题或预案实体")
public class ResponseMessageVo2 {
	
	private int code;
	private QuesOrPlan data;
	private String msg;
		
	public ResponseMessageVo2(String type, List<KeyQVo> keyqList, List<PlanVo> planList, Mpds mpds) {
		this.code = ResponseStatus.SUCCESS.code();
		this.data = new QuesOrPlan(type, keyqList, planList, mpds);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public QuesOrPlan getData() {
		return data;
	}

	public void setData(QuesOrPlan data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

class QuesOrPlan {
	private String type;
	private List<KeyQVo> keyqList;
	private List<PlanVo> planList;
	private Mpds mpds;
	
	public QuesOrPlan(String type, List<KeyQVo> keyqList, List<PlanVo> planList, Mpds mpds) {
		this.type = type;
		this.keyqList = keyqList;
		this.planList = planList;
		this.mpds = mpds;
	}
	
	public List<KeyQVo> getKeyqList() {
		return keyqList;
	}
	public void setKeyqList(List<KeyQVo> keyqList) {
		this.keyqList = keyqList;
	}
	public List<PlanVo> getPlanList() {
		return planList;
	}
	public void setPlanList(List<PlanVo> planList) {
		this.planList = planList;
	}
	public Mpds getMpds() {
		return mpds;
	}
	public void setMpds(Mpds mpds) {
		this.mpds = mpds;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
