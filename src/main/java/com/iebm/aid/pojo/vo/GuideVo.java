package com.iebm.aid.pojo.vo;

import org.springframework.beans.BeanUtils;

import com.iebm.aid.common.GlobalConstants;
import com.iebm.aid.pojo.Guide;
import com.iebm.aid.utils.EBMEnDecrypt;


public class GuideVo {

	private Long uniqId;
	
	private String dir1;
	
	private String dir2;
	
	private String dir3;
	
	private String dir4;
	
	private String dir5;
	
	private String content;
	
	private String picture;
	
	private String keywords;
	
	private String issuingAgency;
	
	private String releaseDate;
	
	private String id;
	
	public GuideVo(Guide guide) {
		BeanUtils.copyProperties(guide, this);
	}

	public Long getUniqId() {
		return uniqId;
	}

	public void setUniqId(Long uniqId) {
		this.uniqId = uniqId;
	}

	public String getDir1() {
		return dir1;
	}

	public void setDir1(String dir1) {
		this.dir1 = dir1;
	}

	public String getDir2() {
		return dir2;
	}

	public void setDir2(String dir2) {
		this.dir2 = dir2;
	}

	public String getDir3() {
		return dir3;
	}

	public void setDir3(String dir3) {
		this.dir3 = dir3;
	}

	public String getDir4() {
		return dir4;
	}

	public void setDir4(String dir4) {
		this.dir4 = dir4;
	}

	public String getDir5() {
		return dir5;
	}

	public void setDir5(String dir5) {
		this.dir5 = dir5;
	}

	public String getContent() {
		content = EBMEnDecrypt.decrypt(content, GlobalConstants.DECRYPT_CHARSET);
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getIssuingAgency() {
		return issuingAgency;
	}

	public void setIssuingAgency(String issuingAgency) {
		this.issuingAgency = issuingAgency;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
