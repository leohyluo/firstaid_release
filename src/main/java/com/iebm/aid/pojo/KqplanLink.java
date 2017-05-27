package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_kqplanlink")
public class KqplanLink extends BaseEntity {

	private static final long serialVersionUID = -7007657724939382453L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	private Long _id;
	
	@Column(name = "mainID")
	private String mainId;
	
	@Column(name = "kqID")
	private String kqId;
	
	@Column(name = "answerId")
	private String answerId;
	
	@Column(name = "planID")
	private String planId;

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getKqId() {
		return kqId;
	}

	public void setKqId(String kqId) {
		this.kqId = kqId;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}
}
