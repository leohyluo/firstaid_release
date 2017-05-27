package com.iebm.aid.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_user_token")
public class UserToken extends BaseEntity {

	private static final long serialVersionUID = -4489377989236419366L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private String id;
	
	@Column(name = "account")
	private String account;

	@Column(name = "token")
	private String token;

	@Column(name = "hospital_code")
	private String hospitalCode;

	@Column(name = "lastupd_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //序列化格式
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //反序列化格式
	private LocalDateTime lastupdTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public LocalDateTime getLastupdTime() {
		return lastupdTime;
	}

	public void setLastupdTime(LocalDateTime lastupdTime) {
		this.lastupdTime = lastupdTime;
	}
	
	
}
