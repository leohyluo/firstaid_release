package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_sysdisease")
public class SysDisease extends BaseEntity {

	private static final long serialVersionUID = 5798856083683011448L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sysId", nullable = false)
	private Long sysId;
	
	@Column(name = "sysName")
	private String sysName;

	public Long getSysId() {
		return sysId;
	}

	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
}
