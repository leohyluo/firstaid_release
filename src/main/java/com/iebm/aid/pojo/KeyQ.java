package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_keyq")
public class KeyQ extends BaseEntity {

	private static final long serialVersionUID = 2923407533235815796L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	private Long uniqId;

	@Column(name = "kqID")
	private Integer kqID;
	
	@Column(name = "mainID")
	private String mainID;
	
	@Column(name = "kqTitle")
	private String kqTitle;
	
	@Column(name = "commExplain")
	private String commExplain;
	
	@Column(name = "proExplain")
	private String proExplain;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "answerId")
	private String answerId;
	
	@Column(name = "kqType")
	private String kqType;
	
	@Column(name = "answerExplain")
	private String answerExplain;
	
	@Column(name = "endFlag")
	private String endFlag;
	
	@Column(name = "forwardFlag")
	private String forwardFlag;
	
	@Column(name = "forwardId")
	private String forwardId;
	
	@Column(name = "gradeScores")
	private String gradeScores;
	
	@Column(name = "gradeIds")
	private String gradeIds;
	
	@Column(name = "mpdsId")
	private String mpdsId;

	public Long getUniqId() {
		return uniqId;
	}

	public void setUniqId(Long uniqId) {
		this.uniqId = uniqId;
	}

	public Integer getKqID() {
		return kqID;
	}

	public void setKqID(Integer kqID) {
		this.kqID = kqID;
	}

	public String getMainID() {
		return mainID;
	}

	public void setMainID(String mainID) {
		this.mainID = mainID;
	}

	public String getKqTitle() {
		return kqTitle;
	}

	public void setKqTitle(String kqTitle) {
		this.kqTitle = kqTitle;
	}

	public String getCommExplain() {
		return commExplain;
	}

	public void setCommExplain(String commExplain) {
		this.commExplain = commExplain;
	}

	public String getProExplain() {
		return proExplain;
	}

	public void setProExplain(String proExplain) {
		this.proExplain = proExplain;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getKqType() {
		return kqType;
	}

	public void setKqType(String kqType) {
		this.kqType = kqType;
	}

	public String getAnswerExplain() {
		return answerExplain;
	}

	public void setAnswerExplain(String answerExplain) {
		this.answerExplain = answerExplain;
	}

	public String getEndFlag() {
		return endFlag;
	}

	public void setEndFlag(String endFlag) {
		this.endFlag = endFlag;
	}

	public String getForwardFlag() {
		return forwardFlag;
	}

	public void setForwardFlag(String forwardFlag) {
		this.forwardFlag = forwardFlag;
	}

	public String getForwardId() {
		return forwardId;
	}

	public void setForwardId(String forwardId) {
		this.forwardId = forwardId;
	}

	public String getGradeScores() {
		return gradeScores;
	}

	public void setGradeScores(String gradeScores) {
		this.gradeScores = gradeScores;
	}

	public String getGradeIds() {
		return gradeIds;
	}

	public void setGradeIds(String gradeIds) {
		this.gradeIds = gradeIds;
	}

	public String getMpdsId() {
		return mpdsId;
	}

	public void setMpdsId(String mpdsId) {
		this.mpdsId = mpdsId;
	}	
}
