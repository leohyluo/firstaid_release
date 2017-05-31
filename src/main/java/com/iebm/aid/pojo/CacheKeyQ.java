package com.iebm.aid.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iebm.aid.common.BaseEntity;

@Entity
@Table(name = "table_cachekeyq")
public class CacheKeyQ extends BaseEntity {


	private static final long serialVersionUID = 5599715086100554999L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	//客户端-呼救任务id
	@Column(name = "userID")
	private String userID;
		
	//呼救主诉id
	@Column(name = "sympID")
	private String sympID;
	
	//患者基本信息，共包含7项数据，用“/”分隔，各数据依次分别为：是否是自己呼救；是否跟患者在一起；年龄段；性别；是否有意识；是否有呼吸；特殊病史id。
	@Column(name = "baseInfos")
	private String baseInfos;
	
	//该请求-对应的所有的问题id，用“/”分隔
	@Column(name = "allKeyQIDs")
	private String allKeyQIDs;
	
	//该请求-对应的所有问题的类型，用“/”分隔
	@Column(name = "allKeyQTypes")
	private String allKeyQTypes;
	
	//问题 引申问题id
	@Column(name = "processKeyQIDs")
	private String processKeyQIDs;
	
	//已问过问题的id，用“/”分隔
	@Column(name = "allKQForwardIDs")
	private String allKQForwardIDs;
	
	//已问过问题的答案id，用“/”分隔
	@Column(name = "processAnswerIDs")
	private String processAnswerIDs;
	
	//请求的时间
	@Column(name = "dateTime")
	private String dateTime;
	
	//服务端-呼救任务ID
	@Column(name = "serverID")
	private String serverId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getSympID() {
		return sympID;
	}

	public void setSympID(String sympID) {
		this.sympID = sympID;
	}

	public String getBaseInfos() {
		return baseInfos;
	}

	public void setBaseInfos(String baseInfos) {
		this.baseInfos = baseInfos;
	}
	
	public String getAllKeyQIDs() {
		return allKeyQIDs;
	}

	public void setAllKeyQIDs(String allKeyQIDs) {
		this.allKeyQIDs = allKeyQIDs;
	}

	public String getAllKeyQTypes() {
		return allKeyQTypes;
	}

	public void setAllKeyQTypes(String allKeyQTypes) {
		this.allKeyQTypes = allKeyQTypes;
	}

	public String getProcessKeyQIDs() {
		return processKeyQIDs;
	}

	public void setProcessKeyQIDs(String processKeyQIDs) {
		this.processKeyQIDs = processKeyQIDs;
	}

	public String getAllKQForwardIDs() {
		return allKQForwardIDs;
	}

	public void setAllKQForwardIDs(String allKQForwardIDs) {
		this.allKQForwardIDs = allKQForwardIDs;
	}

	public String getProcessAnswerIDs() {
		return processAnswerIDs;
	}

	public void setProcessAnswerIDs(String processAnswerIDs) {
		this.processAnswerIDs = processAnswerIDs;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	
}
