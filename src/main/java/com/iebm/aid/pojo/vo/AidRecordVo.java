package com.iebm.aid.pojo.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.pojo.AidRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("急救记录实体")
public class AidRecordVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("急救记录id")
	private Long id;
	
	@ApiModelProperty("主诉")
	private String mainSymptomText;
	
	@ApiModelProperty("患者姓名")
	private String name;
	
	@ApiModelProperty("患者性别")
	private String gender;
	
	@ApiModelProperty("急救时间")
	private LocalDateTime createTime;
	
	public AidRecordVo (AidRecord record) {
		BeanUtils.copyProperties(record, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMainSymptomText() {
		return mainSymptomText;
	}

	public void setMainSymptomText(String mainSymptomText) {
		this.mainSymptomText = mainSymptomText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCreateTime() {
		if(this.createTime != null) {
			return createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
		return null;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	
	
	
}
