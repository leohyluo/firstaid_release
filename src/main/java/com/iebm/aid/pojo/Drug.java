package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@Entity
@Table(name = "table_drugs")
public class Drug extends BaseEntity {

	private static final long serialVersionUID = 3032627585458818999L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	private Long uniqId;
	
	@Column(name = "drugType_0")
	private String type0;
	
	@Column(name = "drugType_1")
	private String type1;

	@Column(name = "drugType_2")
	private String type2;
	
	@Column(name = "drugType_3")
	private String type3;
	
	@ApiModelProperty("药品名称")
	@Column(name = "drugName")
	private String name;
	
	@Column(name = "norm")
	private String norm;
	
	@Column(name = "dosage")
	private String dosage;
	
	@Column(name = "precautions")
	private String precautions;
	
	@Column(name = "sideEffect")
	private String sideEffect;
	
	@Column(name = "indications")
	private String indications;
	
	@Column(name = "contraindications")
	private String contraindications;
	
	@Column(name = "pingyin")
	private String pingyin;
	
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
		return norm;
	}
	public void setNorm(String norm) {
		this.norm = norm;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getPrecautions() {
		return precautions;
	}
	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}
	public String getSideEffect() {
		return sideEffect;
	}
	public void setSideEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}
	public String getIndications() {
		return indications;
	}
	public void setIndications(String indications) {
		this.indications = indications;
	}
	public String getContraindications() {
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
