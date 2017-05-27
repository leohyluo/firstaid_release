package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "table_operatspec")
@ApiModel("操作规范")
public class OperateSpec extends BaseEntity {

	private static final long serialVersionUID = -506348994355629545L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	private Long _id;
	
	@ApiModelProperty("一级（科别）")
	@Column(name = "dir_1")	
	private String dir1;
	
	@ApiModelProperty("二级（章）")
	@Column(name = "dir_2")
	private String dir2;
	
	@ApiModelProperty("三级（节）")
	@Column(name = "dir_3")
	private String dir3;
	
	@ApiModelProperty("四级")
	@Column(name = "dir_4")
	private String dir4;
	
	@ApiModelProperty("五级")
	@Column(name = "dir_5")
	private String dir5;
	
	@ApiModelProperty("概述")
	@Column(name = "overview")
	private String overview;
	
	@ApiModelProperty("适应证")
	@Column(name = "indication")
	private String indication;
	
	@ApiModelProperty("禁忌证")
	@Column(name = "contraindications")
	private String contraindications;
	
	@ApiModelProperty("术前准备")
	@Column(name = "operationPlan")
	private String operationPlan;
	
	@ApiModelProperty("操作方法")
	@Column(name = "operationMethod")
	private String operationMethod;
	
	@ApiModelProperty("注意事项")
	@Column(name = "announcements")
	private String announcements;
	
	@ApiModelProperty("并发症")
	@Column(name = "syndrome")
	private String syndrome;
	
	@Column(name = "id")
	private String id;
	
	@Column(name = "chart")
	private String chart;

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public String getDir1() {
		return dir1;
	}

	public void setDir1(String dir1) {
		this.dir1 = dir1;
	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChart() {
		return chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}

}
