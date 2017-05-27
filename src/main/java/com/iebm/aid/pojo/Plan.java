package com.iebm.aid.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_plan")
public class Plan extends BaseEntity {

	private static final long serialVersionUID = -6681809452819968275L;
	
	public static List<String> GRAVE_PLANS;
	
	static {
		String grave_plan_ids = "40101, 40201, 40301, 40401";
		GRAVE_PLANS = Arrays.asList(grave_plan_ids.split(",")).stream().collect(Collectors.toList());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "planID", nullable = false)
	private String planId;
	
	@Column(name = "mainID")
	private String mainId;
	
	@Column(name = "planTitle")
	private String planTitle;
	
	@Column(name = "planContent")
	private String planContent;
	
	@Column(name = "planType")
	private String planType;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "pinyin")
	private String pinyin;

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public String getPlanContent() {
		return planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	
}
