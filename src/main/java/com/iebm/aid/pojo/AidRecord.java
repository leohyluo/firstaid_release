package com.iebm.aid.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_record")
public class AidRecord extends BaseEntity {

	private static final long serialVersionUID = -6327009243660883114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "files_id")
	private String filesId;
	
	@Column(name = "main_symp")
	private String mainSymptomText;
	
	@Column(name = "cure_process")
	private String cureProcess;
	
	@Column(name = "create_time")
	private LocalDateTime createTime;
	
	//生成预案id集合
	@Column(name = "plan_ids")
	private String planIds;
	
	//事发地点
	@Column(name = "aid_address")
	private String aidAddress;
	
	//呼叫人电话
	@Column(name = "aid_mobile")
	private String aidMobile;
	
	@Column(name = "what_happen")
	private String whatHappen;
	
	//是否与患者一起
	@Column(name = "with_patient")
	private String withPatient;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	//患者年龄
	@Column(name = "age")
	private String age;
	
	//是否有意识
	@Column(name = "has_aware")
	private String hasAware;
	
	//是否有呼吸
	@Column(name = "has_breath")
	private String hasBreath;
	
	@Column(name = "call_type")
	private String callType;

	@Column(name = "creator")
	private String creator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilesId() {
		return filesId;
	}

	public void setFilesId(String filesId) {
		this.filesId = filesId;
	}

	public String getMainSymptomText() {
		return mainSymptomText;
	}

	public void setMainSymptomText(String mainSymptomText) {
		this.mainSymptomText = mainSymptomText;
	}

	public String getCureProcess() {
		return cureProcess;
	}

	public void setCureProcess(String cureProcess) {
		this.cureProcess = cureProcess;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getPlanIds() {
		return planIds;
	}

	public void setPlanIds(String planIds) {
		this.planIds = planIds;
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

	public String getWithPatient() {
		return withPatient;
	}

	public void setWithPatient(String withPatient) {
		this.withPatient = withPatient;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getWhatHappen() {
		return whatHappen;
	}

	public void setWhatHappen(String whatHappen) {
		this.whatHappen = whatHappen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	
}
