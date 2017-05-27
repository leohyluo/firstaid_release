package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("事件信息")
public class EventParam {

	@ApiModelProperty("事件编号")
	private String eventNo;
	@ApiModelProperty("座席号")
	private String seatNo;
	@ApiModelProperty("调度员")
	private String dispatcher;
	@ApiModelProperty("事发地址")
	private String address;
	@ApiModelProperty("报警电话")
	private String incomePhone;
	@ApiModelProperty("报警人")
	private String incomeUserName;
	@ApiModelProperty("事件描述")
	private String description;
	
	public String getEventNo() {
		return eventNo;
	}
	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getDispatcher() {
		return dispatcher;
	}
	public void setDispatcher(String dispatcher) {
		this.dispatcher = dispatcher;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIncomePhone() {
		return incomePhone;
	}
	public void setIncomePhone(String incomePhone) {
		this.incomePhone = incomePhone;
	}
	public String getIncomeUserName() {
		return incomeUserName;
	}
	public void setIncomeUserName(String incomeUserName) {
		this.incomeUserName = incomeUserName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
