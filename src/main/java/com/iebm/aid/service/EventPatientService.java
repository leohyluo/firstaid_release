package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.EventPatient;


public interface EventPatientService extends BaseService<EventPatient, Long> {

	List<EventPatient> findByEventNo(String eventNo);
}
