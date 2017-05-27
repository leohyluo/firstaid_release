package com.iebm.aid.pojo.vo;

import java.util.List;

public class PlanResultVo {

	private String grade;
	private List<PlanVo> voList;
	
	public PlanResultVo(String grade, List<PlanVo> voList) {
		this.grade = grade;
		this.voList = voList;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public List<PlanVo> getVoList() {
		return voList;
	}
	public void setVoList(List<PlanVo> voList) {
		this.voList = voList;
	}	
}
