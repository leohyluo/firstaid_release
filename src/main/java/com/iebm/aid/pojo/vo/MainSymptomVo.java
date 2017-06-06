package com.iebm.aid.pojo.vo;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.common.GlobalConstants;
import com.iebm.aid.pojo.MainSymptom;
import com.iebm.aid.utils.EBMEnDecrypt;


public class MainSymptomVo {

	private String mainId;
	
	private String title;
	
	private String code;
	
	public MainSymptomVo (MainSymptom mainSymptom) {
		BeanUtils.copyProperties(mainSymptom, this);
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getTitle() {
		title = EBMEnDecrypt.decrypt(title, GlobalConstants.DECRYPT_CHARSET);
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		code = EBMEnDecrypt.decrypt(code, GlobalConstants.DECRYPT_CHARSET);
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
