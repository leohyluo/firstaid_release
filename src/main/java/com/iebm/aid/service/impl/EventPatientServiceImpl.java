package com.iebm.aid.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.EventPatient;
import com.iebm.aid.repository.EventPatientRepository;
import com.iebm.aid.service.EventPatientService;

@Service
public class EventPatientServiceImpl extends AbstractService<EventPatient, Long> implements EventPatientService {

	@Resource
	private EventPatientRepository repository;
	
	@Override
	public List<EventPatient> findByEventNo(String eventNo) {
		return repository.findByEventNo(eventNo);
	}
	
	@Override
	protected BaseRepository<EventPatient, Long> getRepository() {
		return repository;
	}
	
}
