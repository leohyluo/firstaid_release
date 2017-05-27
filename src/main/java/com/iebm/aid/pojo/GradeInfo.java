package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_gradeinfo")
public class GradeInfo extends BaseEntity {

	private static final long serialVersionUID = 8715026651910847169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	private Long uniqId;
	
	@Column(name = "gradeID")
	private String gradeId;
	
	@Column(name = "gradName")
	private String gradName;
	
	@Column(name = "minScore")
	private String minScore;
	
	@Column(name = "maxScore")
	private String maxScore;
	
	@Column(name = "result")
	private String result;
	
	@Column(name = "remark")
	private String remark;

	public Long getUniqId() {
		return uniqId;
	}

	public void setUniqId(Long uniqId) {
		this.uniqId = uniqId;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradName() {
		return gradName;
	}

	public void setGradName(String gradName) {
		this.gradName = gradName;
	}

	public String getMinScore() {
		return minScore;
	}

	public void setMinScore(String minScore) {
		this.minScore = minScore;
	}

	public String getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(String maxScore) {
		this.maxScore = maxScore;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
