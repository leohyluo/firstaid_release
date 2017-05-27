package com.iebm.aid.pojo.vo;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.pojo.SpecDisease;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("急危重症列表(视图)")
public class SpecDiseaseVo {

	@ApiModelProperty("疾病id")
	private Long disId;
	
	@ApiModelProperty("疾病名称")
	private String disName;
	
	public Long getDisId() {
		return disId;
	}
	public void setDisId(Long disId) {
		this.disId = disId;
	}
	public String getDisName() {
		return disName;
	}
	public void setDisName(String disName) {
		this.disName = disName;
	}
	
	public SpecDiseaseVo(SpecDisease sd) {
		BeanUtils.copyProperties(sd, this);
	}
}
