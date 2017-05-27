package com.iebm.aid.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("急救档案实体-患者基本信息")
public class PatientInfo {

	@ApiModelProperty("姓名")
	private String userName; //姓名

	@ApiModelProperty("性别")
	private String gender; //性别（男，女，不详，空）

	@ApiModelProperty("出生日期")
	private String birth; //出生日期

	@ApiModelProperty("民族")
	private String national; //民族

	@ApiModelProperty("婚姻状况")
	private String marriage; //婚姻（未婚，已婚，不详，空）

	@ApiModelProperty("既往病史")
	private String pastIll; //既往病史

	@ApiModelProperty("药物过敏史")
	private String historyDrugAllergy; //药物过敏史

	@ApiModelProperty("医保号")
	private String medicalCardNo; //医保号

	@ApiModelProperty("工作单位")
	private String company; //工作单位

	@ApiModelProperty("职业")
	private String job; //职业

	@ApiModelProperty("联系电话")
	private String mobile; //联系电话

	@ApiModelProperty("联系地址")
	private String address; //联系地址

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getPastIll() {
		return pastIll;
	}

	public void setPastIll(String pastIll) {
		this.pastIll = pastIll;
	}

	public String getHistoryDrugAllergy() {
		return historyDrugAllergy;
	}

	public void setHistoryDrugAllergy(String historyDrugAllergy) {
		this.historyDrugAllergy = historyDrugAllergy;
	}

	public String getMedicalCardNo() {
		return medicalCardNo;
	}

	public void setMedicalCardNo(String medicalCardNo) {
		this.medicalCardNo = medicalCardNo;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
