package com.iebm.aid.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.EventMessage;
import com.iebm.aid.repository.EventMessageRepository;
import com.iebm.aid.service.EventMessageService;

@Service
public class EventMessageServiceImpl extends AbstractService<EventMessage, Long> implements EventMessageService{

	@Resource
	private EventMessageRepository repository;
	
	@Override
	protected BaseRepository<EventMessage, Long> getRepository() {
		return repository;
	}
	
}
