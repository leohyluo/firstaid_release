package com.iebm.aid.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.UserSubStation;
import com.iebm.aid.repository.UserSubstationRepository;
import com.iebm.aid.service.UserSubstationService;

@Service
public class UserSubstationServiceImpl extends AbstractService<UserSubStation, Long> implements UserSubstationService {

	@Resource
	private UserSubstationRepository repository;
	
	@Override
	protected BaseRepository<UserSubStation, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}
