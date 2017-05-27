package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_keyquse")
public class KeyQUse extends BaseEntity {

	private static final long serialVersionUID = -7061186030715505987L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	private Long uniqId;
	
	@Column(name = "mainID")
	private String mainID;
	
	@Column(name = "kqID")
	private String kqID;
	
	@Column(name = "answerId1")
	private String callType;
	
	@Column(name = "answerId2")
	private String withPatient;
	
	@Column(name = "answerId3")
	private String age;
	
	@Column(name = "answerId4")
	private String gender;
	
	@Column(name = "answerId5")
	private String hasAware;
	
	@Column(name = "answerId6")
	private String hasBreath;
	
	@Column(name = "disID")
	private String disID;

	public Long getUniqId() {
		return uniqId;
	}

	public void setUniqId(Long uniqId) {
		this.uniqId = uniqId;
	}

	public String getMainID() {
		return mainID;
	}

	public void setMainID(String mainID) {
		this.mainID = mainID;
	}

	public String getKqID() {
		return kqID;
	}

	public void setKqID(String kqID) {
		this.kqID = kqID;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
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

	public String getDisID() {
		return disID;
	}

	public void setDisID(String disID) {
		this.disID = disID;
	}

}
