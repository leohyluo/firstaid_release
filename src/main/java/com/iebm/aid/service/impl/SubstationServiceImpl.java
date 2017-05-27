package com.iebm.aid.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.SubStation;
import com.iebm.aid.repository.SubStationRepository;
import com.iebm.aid.service.SubstationService;

@Service
public class SubstationServiceImpl extends AbstractService<SubStation, Long> implements SubstationService {

	@Resource
	private SubStationRepository repository;
	
	@Override
	protected BaseRepository<SubStation, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}	
}
