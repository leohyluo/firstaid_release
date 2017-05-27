package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_patient_record")
public class PatientRecord extends BaseEntity {

	private static final long serialVersionUID = 1478370737001104506L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "patient_id")
	private String patientId;

	@Column(name = "eventNo")
	private String eventNo;

	@Column(name = "what_happen")
	private String whatHappen;

	@Column(name = "call_type")
	private String callType;

	@Column(name = "has_consc")
	private String hasConsc;

	@Column(name = "has_breath")
	private String hasBreath;

	@Column(name = "mainSymp_id")
	private String mainSympId;

	@Column(name = "question_ids")
	private String questionIds;

	@Column(name = "answer_ids")
	private String answerIs;

	@Column(name = "subSymp_text")
	private String subSympText;

	@Column(name = "plan_ids")
	private String planIds;

	@Column(name = "version")
	private String version;

	@Column(name = "create_time")
	private String createTime;

	@Column(name = "create_user")
	private String createUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getEventNo() {
		return eventNo;
	}

	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}

	public String getWhatHappen() {
		return whatHappen;
	}

	public void setWhatHappen(String whatHappen) {
		this.whatHappen = whatHappen;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getHasConsc() {
		return hasConsc;
	}

	public void setHasConsc(String hasConsc) {
		this.hasConsc = hasConsc;
	}

	public String getHasBreath() {
		return hasBreath;
	}

	public void setHasBreath(String hasBreath) {
		this.hasBreath = hasBreath;
	}

	public String getMainSympId() {
		return mainSympId;
	}

	public void setMainSympId(String mainSympId) {
		this.mainSympId = mainSympId;
	}

	public String getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(String questionIds) {
		this.questionIds = questionIds;
	}

	public String getAnswerIs() {
		return answerIs;
	}

	public void setAnswerIs(String answerIs) {
		this.answerIs = answerIs;
	}

	public String getSubSympText() {
		return subSympText;
	}

	public void setSubSympText(String subSympText) {
		this.subSympText = subSympText;
	}

	public String getPlanIds() {
		return planIds;
	}

	public void setPlanIds(String planIds) {
		this.planIds = planIds;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

}
