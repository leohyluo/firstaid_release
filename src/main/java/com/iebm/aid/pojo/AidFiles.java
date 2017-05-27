package com.iebm.aid.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("急救档案实体")
@Entity
@Table(name = "table_aid_files")
public class AidFiles extends BaseEntity {

	private static final long serialVersionUID = 2132400974943309743L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "user_id")
	private String userId; //用户编号，对应于表“table_recordUser”中的“userNum”项

	@ApiModelProperty("姓名")
	@Column(name = "user_name")
	private String userName; //姓名

	@ApiModelProperty("性别")
	@Column(name = "gender")
	private String gender; //性别（男，女，不详，空）

	@ApiModelProperty("出生日期")
	@Column(name = "birth")
	private String birth; //出生日期

	@ApiModelProperty("民族")
	@Column(name = "national")
	private String national; //民族

	@ApiModelProperty("婚姻状况")
	@Column(name = "marriage")
	private String marriage; //婚姻（未婚，已婚，不详，空）

	@ApiModelProperty("既往病史")
	@Column(name = "past_ill")
	private String pastIll; //既往病史

	@ApiModelProperty("药物过敏史")
	@Column(name = "history_drugAllergy")
	private String historyDrugAllergy; //药物过敏史

	@ApiModelProperty("医保号")
	@Column(name = "medical_cardNo")
	private String medicalCardNo; //医保号

	@ApiModelProperty("工作单位")
	@Column(name = "company")
	private String company; //工作单位

	@ApiModelProperty("职业")
	@Column(name = "job")
	private String job; //职业

	@ApiModelProperty("联系电话")
	@Column(name = "mobile")
	private String mobile; //联系电话

	@ApiModelProperty("联系地址")
	@Column(name = "address")
	private String address; //联系地址

	@ApiModelProperty("急诊时间")
	@Column(name = "cure_time")
	private String cureTime; //急诊时间

	@ApiModelProperty("主诉")
	@Column(name = "main_symp")
	private String mainSymp; //主诉

	@ApiModelProperty("现病史")
	@Column(name = "now_ill")
	private String nowIll; //现病史

	@ApiModelProperty("既往史")
	@Column(name = "past_ill2")
	private String pastIll2; //既往史

	@ApiModelProperty("体格检查")
	@Column(name = "body_check")
	private String bodyCheck; //体检

	@ApiModelProperty("辅助检查")
	@Column(name = "assis_check")
	private String assisCheck; //辅助检查

	@ApiModelProperty("初步诊断")
	@Column(name = "diagnosis")
	private String diagnosis; //初步诊断

	@ApiModelProperty("处理原则")
	@Column(name = "principle")
	private String principle; //处理原则

	@ApiModelProperty("医师签名")
	@Column(name = "signature")
	private String signature; //医师签名

	@Column(name = "lastupd_time")
	private LocalDateTime lastupdTime; //修改及操作时间

	@Column(name = "create_time")
	private LocalDateTime createTime; //用于创建的时间毫秒数private String 
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getPastIll() {
		return pastIll;
	}
	public void setPastIll(String pastIll) {
		this.pastIll = pastIll;
	}
	public String getHistoryDrugAllergy() {
		return historyDrugAllergy;
	}
	public void setHistoryDrugAllergy(String historyDrugAllergy) {
		this.historyDrugAllergy = historyDrugAllergy;
	}
	public String getMedicalCardNo() {
		return medicalCardNo;
	}
	public void setMedicalCardNo(String medicalCardNo) {
		this.medicalCardNo = medicalCardNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCureTime() {
		return cureTime;
	}
	public void setCureTime(String cureTime) {
		this.cureTime = cureTime;
	}
	public String getMainSymp() {
		return mainSymp;
	}
	public void setMainSymp(String mainSymp) {
		this.mainSymp = mainSymp;
	}
	public String getNowIll() {
		return nowIll;
	}
	public void setNowIll(String nowIll) {
		this.nowIll = nowIll;
	}
	public String getPastIll2() {
		return pastIll2;
	}
	public void setPastIll2(String pastIll2) {
		this.pastIll2 = pastIll2;
	}
	public String getBodyCheck() {
		return bodyCheck;
	}
	public void setBodyCheck(String bodyCheck) {
		this.bodyCheck = bodyCheck;
	}
	public String getAssisCheck() {
		return assisCheck;
	}
	public void setAssisCheck(String assisCheck) {
		this.assisCheck = assisCheck;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getPrinciple() {
		return principle;
	}
	public void setPrinciple(String principle) {
		this.principle = principle;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public LocalDateTime getLastupdTime() {
		return lastupdTime;
	}
	public void setLastupdTime(LocalDateTime lastupdTime) {
		this.lastupdTime = lastupdTime;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
}
