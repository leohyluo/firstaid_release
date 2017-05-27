package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_guide")
public class Guide extends BaseEntity {

	private static final long serialVersionUID = 3111012229959853899L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	private Long uniqId;
	
	@Column(name = "dir_1")
	private String dir1;
	
	@Column(name = "dir_2")
	private String dir2;
	
	@Column(name = "dir_3")
	private String dir3;
	
	@Column(name = "dir_4")
	private String dir4;
	
	@Column(name = "dir_5")
	private String dir5;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "keywords")
	private String keywords;
	
	@Column(name = "issuingAgency")
	private String issuingAgency;
	
	@Column(name = "releaseDate")
	private String releaseDate;
	
	@Column(name = "id")
	private String id;

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
