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
import com.iebm.aid.controller.req.EventParam;

@Entity
@Table(name = "table_event_record")
public class EventRecord extends BaseEntity {

	private static final long serialVersionUID = -4301534986320671781L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "eventNo")
	private String eventNo;

	@Column(name = "seatNo")
	private String seatNo;

	@Column(name = "dispatcher")
	private String dispatcher;

	@Column(name = "address")
	private String address;

	@Column(name = "income_phone")
	private String incomePhone;

	@Column(name = "income_userName")
	private String incomeUserName;

	@Column(name = "description")
	private String description;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "create_time")
	private LocalDateTime createTime;

	@Column(name = "lastupd_time")
	private LocalDateTime lastupdTime;
	
	public EventRecord(EventParam obj) {
		BeanUtils.copyProperties(obj, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventNo() {
		return eventNo;
	}

	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(String dispatcher) {
		this.dispatcher = dispatcher;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIncomePhone() {
		return incomePhone;
	}

	public void setIncomePhone(String incomePhone) {
		this.incomePhone = incomePhone;
	}

	public String getIncomeUserName() {
		return incomeUserName;
	}

	public void setIncomeUserName(String incomeUserName) {
		this.incomeUserName = incomeUserName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getLastupdTime() {
		return lastupdTime;
	}

	public void setLastupdTime(LocalDateTime lastupdTime) {
		this.lastupdTime = lastupdTime;
	}
	
}
