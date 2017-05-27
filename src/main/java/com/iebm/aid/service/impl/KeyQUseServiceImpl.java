package com.iebm.aid.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.KeyQUse;
import com.iebm.aid.repository.KeyQUseRepository;
import com.iebm.aid.service.KeyQUseService;

@Service
public class KeyQUseServiceImpl extends AbstractService<KeyQUse, Long> implements KeyQUseService {

	@Resource
	private KeyQUseRepository repository;
	
	@Override
	public List<KeyQUse> findByMainSymptomId(String mainSymptomId) {
		return repository.findByMainID(mainSymptomId);
	}

	@Override
	protected BaseRepository<KeyQUse, Long> getRepository() {
		return repository;
	}
}
