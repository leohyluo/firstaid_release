package com.iebm.aid.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("问诊数据载体")
public class KeyQReq {

	@ApiModelProperty("主症状id")
	private String mainId;
	@ApiModelProperty("问题编号组合,以逗号分隔")
	private String questionNos;
	@ApiModelProperty("答案id组合,以逗号分隔")
	private String answerIds;
	
	public String getMainId() {
		return mainId;
	}
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	public String getQuestionNos() {
		return questionNos;
	}
	public void setQuestionNos(String questionNos) {
		this.questionNos = questionNos;
	}
	public String getAnswerIds() {
		return answerIds;
	}
	public void setAnswerIds(String answerIds) {
		this.answerIds = answerIds;
	}
}
