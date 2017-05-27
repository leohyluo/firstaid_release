package com.iebm.aid.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("急救档案-急诊记录")
public class EmengencyRecord {

	@ApiModelProperty("急诊时间")
	private String cureTime; //急诊时间

	@ApiModelProperty("主诉")
	private String mainSymp; //主诉

	@ApiModelProperty("现病史")
	private String nowIll; //现病史

	@ApiModelProperty("既往史")
	private String pastIll2; //既往史

	@ApiModelProperty("体格检查")
	private String bodyCheck; //体检

	@ApiModelProperty("辅助检查")
	private String assisCheck; //辅助检查

	@ApiModelProperty("初步诊断")
	private String diagnosis; //初步诊断

	@ApiModelProperty("处理原则")
	private String principle; //处理原则

	@ApiModelProperty("医师签名")
	private String signature; //医师签名

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
	
	
}
