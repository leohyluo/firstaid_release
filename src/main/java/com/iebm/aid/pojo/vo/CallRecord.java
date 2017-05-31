package com.iebm.aid.pojo.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("急救档案-呼叫记录")
public class CallRecord {
	
	@ApiModelProperty("预案")
	private List<PlanVo> plans;

	@ApiModelProperty("主诉id")
	private String mainSymptom;
	
	//是否是自己呼救
	@ApiModelProperty("是否是自己呼救(1：自己呼救 2：熟人帮助呼救 3：陌生人帮助呼救)")
	private String callType;
	
	//是否跟患者在一起
	@ApiModelProperty("是否跟患者在一起 1：是 2:否")
	private String stayWithPatient;
	
	@ApiModelProperty("患者姓名")
	private String name;
	
	//年龄段
	@ApiModelProperty("年龄段")
	private String age;
	
	//性别
	@ApiModelProperty("性别 1：男 2：女 3：不详")
	private String gender;
	
	//是否有意识
	@ApiModelProperty("是否有意识 1：有意识 2：没有意识 3：不详")
	private String hasAware;
	
	//是否有呼吸
	@ApiModelProperty("是否有呼吸 1：有呼吸 2：没有呼吸 3：不详")
	private String hasBreath;
	
	//特殊病史id
	@ApiModelProperty("特殊病史id")
	private String specDisId;
	
	//事发地点
	@ApiModelProperty("事发地点")
	private String aidAddress;
	
	//呼叫人电话
	@ApiModelProperty("呼叫人电话")
	private String aidMobile;
	
	//发生了什么
	@ApiModelProperty("发生了什么")
	private String whatHappen;
	
	@ApiModelProperty("诊断过程")
	private String cureProcess;

	public String getMainSymptom() {
		return mainSymptom;
	}

	public void setMainSymptom(String mainSymptom) {
		this.mainSymptom = mainSymptom;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getStayWithPatient() {
		return stayWithPatient;
	}

	public void setStayWithPatient(String stayWithPatient) {
		this.stayWithPatient = stayWithPatient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHasAware() {
		return hasAware;
	}

	public void setHasAware(String hasAware) {
		this.hasAware = hasAware;
	}

	public String getHasBreath() {
		return hasBreath;
	}

	public void setHasBreath(String hasBreath) {
		this.hasBreath = hasBreath;
	}

	public String getSpecDisId() {
		return specDisId;
	}

	public void setSpecDisId(String specDisId) {
		this.specDisId = specDisId;
	}

	public String getAidAddress() {
		return aidAddress;
	}

	public void setAidAddress(String aidAddress) {
		this.aidAddress = aidAddress;
	}

	public String getAidMobile() {
		return aidMobile;
	}

	public void setAidMobile(String aidMobile) {
		this.aidMobile = aidMobile;
	}

	public String getWhatHappen() {
		return whatHappen;
	}

	public void setWhatHappen(String whatHappen) {
		this.whatHappen = whatHappen;
	}

	public String getCureProcess() {
		return cureProcess;
	}

	public void setCureProcess(String cureProcess) {
		this.cureProcess = cureProcess;
	}

	public List<PlanVo> getPlans() {
		return plans;
	}

	public void setPlans(List<PlanVo> plans) {
		this.plans = plans;
	}
	
	
}
