package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_specdisease")
public class SpecDisease extends BaseEntity {

	private static final long serialVersionUID = -6681809452819968275L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "disId", nullable = false)
	private Long disId;
	
	@Column(name = "sysId")
	private String sysId;
	
	@Column(name = "subId")
	private String subId;
	
	@Column(name = "disName")
	private String disName;
	
	@Column(name = "disIntro")
	private String disIntro;
	
	@Column(name = "disDiagnosisBased")
	private String disDiagnosisBased;
	
	@Column(name = "disTreatmentGuidelines")
	private String disTreatmentGuidelines;
	
	@Column(name ="disOtherMeasures")
	private String disOtherMeasures;
	
	@Column(name = "pingyin")
	private String pingyin;

	public Long getDisId() {
		return disId;
	}

	public void setDisId(Long disId) {
		this.disId = disId;
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getDisName() {
		return disName;
	}

	public void setDisName(String disName) {
		this.disName = disName;
	}

	public String getDisIntro() {
		return disIntro;
	}

	public void setDisIntro(String disIntro) {
		this.disIntro = disIntro;
	}

	public String getDisDiagnosisBased() {
		return disDiagnosisBased;
	}

	public void setDisDiagnosisBased(String disDiagnosisBased) {
		this.disDiagnosisBased = disDiagnosisBased;
	}

	public String getDisTreatmentGuidelines() {
		return disTreatmentGuidelines;
	}

	public void setDisTreatmentGuidelines(String disTreatmentGuidelines) {
		this.disTreatmentGuidelines = disTreatmentGuidelines;
	}

	public String getDisOtherMeasures() {
		return disOtherMeasures;
	}

	public void setDisOtherMeasures(String disOtherMeasures) {
		this.disOtherMeasures = disOtherMeasures;
	}

	public String getPingyin() {
		return pingyin;
	}

	public void setPingyin(String pingyin) {
		this.pingyin = pingyin;
	}
	
	
}
