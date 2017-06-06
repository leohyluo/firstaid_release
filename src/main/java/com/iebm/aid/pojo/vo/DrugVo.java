package com.iebm.aid.pojo.vo;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.common.GlobalConstants;
import com.iebm.aid.pojo.Drug;
import com.iebm.aid.utils.EBMEnDecrypt;


public class DrugVo {

	private Long uniqId;
	
	private String type0;
	
	private String type1;

	private String type2;
	
	private String type3;
	
	private String name;
	
	private String norm;
	
	private String dosage;
	
	private String precautions;
	
	private String sideEffect;
	
	private String indications;
	
	private String contraindications;
	
	private String pingyin;
	
	public DrugVo(Drug drug) {
		BeanUtils.copyProperties(drug, this);
	}
	
	public Long getUniqId() {
		return uniqId;
	}
	public void setUniqId(Long uniqId) {
		this.uniqId = uniqId;
	}
	public String getType0() {
		return type0;
	}
	public void setType0(String type0) {
		this.type0 = type0;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNorm() {
		norm = EBMEnDecrypt.decrypt(norm, GlobalConstants.DECRYPT_CHARSET);
		return norm;
	}
	public void setNorm(String norm) {
		this.norm = norm;
	}
	public String getDosage() {
		dosage = EBMEnDecrypt.decrypt(dosage, GlobalConstants.DECRYPT_CHARSET);
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getPrecautions() {
		precautions = EBMEnDecrypt.decrypt(precautions, GlobalConstants.DECRYPT_CHARSET);
		return precautions;
	}
	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}
	public String getSideEffect() {
		sideEffect = EBMEnDecrypt.decrypt(sideEffect, GlobalConstants.DECRYPT_CHARSET);
		return sideEffect;
	}
	public void setSideEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}
	public String getIndications() {
		indications = EBMEnDecrypt.decrypt(indications, GlobalConstants.DECRYPT_CHARSET);
		return indications;
	}
	public void setIndications(String indications) {
		this.indications = indications;
	}
	public String getContraindications() {
		contraindications = EBMEnDecrypt.decrypt(contraindications, GlobalConstants.DECRYPT_CHARSET);
		return contraindications;
	}
	public void setContraindications(String contraindications) {
		this.contraindications = contraindications;
	}
	public String getPingyin() {
		return pingyin;
	}
	public void setPingyin(String pingyin) {
		this.pingyin = pingyin;
	}
	
}
