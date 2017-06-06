package com.iebm.aid.pojo.vo;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.common.GlobalConstants;
import com.iebm.aid.pojo.SpecDisease;
import com.iebm.aid.utils.EBMEnDecrypt;


public class SpecDiseaseVo2 {

	private Long disId;
	
	private String sysId;
	
	private String subId;
	
	private String disName;
	
	private String disIntro;
	
	private String disDiagnosisBased;
	
	private String disTreatmentGuidelines;
	
	private String disOtherMeasures;
	
	private String pingyin;

	public SpecDiseaseVo2(SpecDisease sd) {
		BeanUtils.copyProperties(sd, this);
	}
	
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
		disIntro = EBMEnDecrypt.decrypt(disIntro, GlobalConstants.DECRYPT_CHARSET);
		return disIntro;
	}

	public void setDisIntro(String disIntro) {
		this.disIntro = disIntro;
	}

	public String getDisDiagnosisBased() {
		disDiagnosisBased = EBMEnDecrypt.decrypt(disDiagnosisBased, GlobalConstants.DECRYPT_CHARSET);
		return disDiagnosisBased;
	}

	public void setDisDiagnosisBased(String disDiagnosisBased) {
		this.disDiagnosisBased = disDiagnosisBased;
	}

	public String getDisTreatmentGuidelines() {
		disTreatmentGuidelines = EBMEnDecrypt.decrypt(disTreatmentGuidelines, GlobalConstants.DECRYPT_CHARSET);
		return disTreatmentGuidelines;
	}

	public void setDisTreatmentGuidelines(String disTreatmentGuidelines) {
		this.disTreatmentGuidelines = disTreatmentGuidelines;
	}

	public String getDisOtherMeasures() {
		disOtherMeasures = EBMEnDecrypt.decrypt(disOtherMeasures, GlobalConstants.DECRYPT_CHARSET);
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
