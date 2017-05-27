package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_user_sub_station")
public class UserSubStation extends BaseEntity {

	private static final long serialVersionUID = 2775277985060904352L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "user_id")
	private String userId;

	@Column(name = "station_id")
	private String stationId;

	@Column(name = "hospital_code")
	private String hospitalCode;

	@Column(name = "lastupd_time")
	private String lastupdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getLastupdTime() {
		return lastupdTime;
	}

	public void setLastupdTime(String lastupdTime) {
		this.lastupdTime = lastupdTime;
	}
	
	
}
