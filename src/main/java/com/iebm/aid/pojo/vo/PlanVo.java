package com.iebm.aid.pojo.vo;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.common.GlobalConstants;
import com.iebm.aid.pojo.Plan;
import com.iebm.aid.utils.EBMEnDecrypt;

public class PlanVo {

	private String planId;
	private String planTitle;
	private String planContent;
	
	public PlanVo(Plan obj) {
		BeanUtils.copyProperties(obj, this);
	}
	
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanTitle() {
		planTitle = EBMEnDecrypt.decrypt(planTitle, GlobalConstants.DECRYPT_CHARSET);
		return planTitle;
	}
	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}
	public String getPlanContent() {
		planContent = EBMEnDecrypt.decrypt(planContent, GlobalConstants.DECRYPT_CHARSET);
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
}
