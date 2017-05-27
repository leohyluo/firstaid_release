package com.iebm.aid.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.common.BaseEntity;
import com.iebm.aid.controller.req.PatientParam;

@Entity
@Table(name = "table_event_patient")
public class EventPatient extends BaseEntity {

	private static final long serialVersionUID = 6519163330608324128L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="eventId")
	private Long eventId;

	@Column(name="eventNo")
	private String eventNo;

	@Column(name="patient_name")
	private String patientName;

	@Column(name="age")
	private int age;

	@Column(name="age_unit")
	private String ageUnit;

	@Column(name="gender")
	private String gender;

	@Column(name="address")
	private String address;

	@Column(name="mobile")
	private String mobile;

	@Column(name="create_time")
	private LocalDateTime createTime;

	@Column(name="create_user")
	private String createUser;

	@Column(name="lastupd_time")
	private LocalDateTime lastupdTime;

	@Column(name="lastupd_user")
	private String lastupdUser;

	public EventPatient() {}
	
	public EventPatient(PatientParam obj) {
		BeanUtils.copyProperties(obj, this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventNo() {
		return eventNo;
	}

	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAgeUnit() {
		return ageUnit;
	}

	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public LocalDateTime getLastupdTime() {
		return lastupdTime;
	}

	public void setLastupdTime(LocalDateTime lastupdTime) {
		this.lastupdTime = lastupdTime;
	}

	public String getLastupdUser() {
		return lastupdUser;
	}

	public void setLastupdUser(String lastupdUser) {
		this.lastupdUser = lastupdUser;
	}
	
}
