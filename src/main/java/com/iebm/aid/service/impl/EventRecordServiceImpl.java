package com.iebm.aid.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.controller.req.EventParam;
import com.iebm.aid.controller.req.PatientParam;
import com.iebm.aid.pojo.EventPatient;
import com.iebm.aid.pojo.EventRecord;
import com.iebm.aid.pojo.User;
import com.iebm.aid.repository.EventRecordRepository;
import com.iebm.aid.service.EventPatientService;
import com.iebm.aid.service.EventRecordService;

@Service
@Transactional
public class EventRecordServiceImpl extends AbstractService<EventRecord, Long> implements EventRecordService{
	
	@Resource
	private EventRecordRepository repository;
	@Resource
	private EventPatientService eventPatientService;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEventInfo(User user, EventParam eventParam, List<PatientParam> patientList) {
		if(eventParam == null) {
			return;
		}
		EventRecord eventRecord = new EventRecord(eventParam);
		eventRecord.setCreateUser(String.valueOf(user.getId()));
		repository.save(eventRecord);
		
		if(!CollectionUtils.isEmpty(patientList)) {
			Long eventId = eventRecord.getId();
			String eventNo = eventParam.getEventNo();
			List<EventPatient> eventPatientList = patientList.stream().map(EventPatient::new).collect(Collectors.toList());
			eventPatientList.stream().peek(e->{
				e.setEventId(eventId);
				e.setEventNo(eventNo);
				e.setCreateUser(String.valueOf(user.getId()));
			}).collect(Collectors.toList());
			eventPatientService.save(eventPatientList);
		}
	}
	
	@Override
	public List<EventRecord> findByEventNo(String eventNo) {
		return repository.findByEventNo(eventNo);
	}
	
	@Override
	protected BaseRepository<EventRecord, Long> getRepository() {
		return repository;
	}

	
}
