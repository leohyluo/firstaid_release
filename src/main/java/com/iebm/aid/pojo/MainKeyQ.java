package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_mainkeyq")
public class MainKeyQ extends BaseEntity {

	private static final long serialVersionUID = 6608239835575639474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id", nullable = false)
	private Long uniqId;
	
	@Column(name="kqID")
	private String questionId;
	
	@Column(name = "kqTitle")
	private String title;
	
	@Column(name = "commExplain")
	private String commonExplain;
	
	@Column(name = "proExplain")
	private String proExplain;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "answerId")
	private String answerId;
	
	@Column(name = "kqType")
	private String type;
	
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

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCommonExplain() {
		return commonExplain;
	}

	public void setCommonExplain(String commonExplain) {
		this.commonExplain = commonExplain;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Long getUniqId() {
		return uniqId;
	}

	public void setUniqId(Long uniqId) {
		this.uniqId = uniqId;
	}
	
	
}
