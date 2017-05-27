package com.iebm.aid.pojo.vo;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.pojo.OperateSpec;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("操作规范结果视图")
public class OperateSpecVo {

	@ApiModelProperty("二级（章）")
	private String dir2;
	
	@ApiModelProperty("三级（节）")
	private String dir3;
	
	@ApiModelProperty("四级")
	private String dir4;
	
	@ApiModelProperty("五级")
	private String dir5;
	
	@ApiModelProperty("概述")
	private String overview;
	
	@ApiModelProperty("适应证")
	private String indication;
	
	@ApiModelProperty("禁忌证")
	private String contraindications;
	
	@ApiModelProperty("术前准备")
	private String operationPlan;
	
	@ApiModelProperty("操作方法")
	private String operationMethod;
	
	@ApiModelProperty("注意事项")
	private String announcements;
	
	@ApiModelProperty("并发症")
	private String syndrome;
	
	@ApiModelProperty("图表")
	private String chart;

	public String getDir2() {
		return dir2;
	}

	public void setDir2(String dir2) {
		this.dir2 = dir2;
	}

	public String getDir3() {
		return dir3;
	}

	public void setDir3(String dir3) {
		this.dir3 = dir3;
	}

	public String getDir4() {
		return dir4;
	}

	public void setDir4(String dir4) {
		this.dir4 = dir4;
	}

	public String getDir5() {
		return dir5;
	}

	public void setDir5(String dir5) {
		this.dir5 = dir5;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getContraindications() {
		return contraindications;
	}

	public void setContraindications(String contraindications) {
		this.contraindications = contraindications;
	}

	public String getOperationPlan() {
		return operationPlan;
	}

	public void setOperationPlan(String operationPlan) {
		this.operationPlan = operationPlan;
	}

	public String getOperationMethod() {
		return operationMethod;
	}

	public void setOperationMethod(String operationMethod) {
		this.operationMethod = operationMethod;
	}

	public String getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(String announcements) {
		this.announcements = announcements;
	}

	public String getSyndrome() {
		return syndrome;
	}

	public void setSyndrome(String syndrome) {
		this.syndrome = syndrome;
	}

	public String getChart() {
		return chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}

	public OperateSpecVo(OperateSpec os) {
		BeanUtils.copyProperties(os, this);
	} 
}
