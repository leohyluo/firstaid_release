package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.controller.req.EventParam;
import com.iebm.aid.controller.req.PatientParam;
import com.iebm.aid.pojo.EventRecord;
import com.iebm.aid.pojo.User;

public interface EventRecordService extends BaseService<EventRecord, Long> {
	
	void saveEventInfo(User user, EventParam eventParam, List<PatientParam> patientList);
	
	List<EventRecord> findByEventNo(String eventNo);
}
