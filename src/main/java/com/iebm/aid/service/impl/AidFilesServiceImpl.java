package com.iebm.aid.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.AidFiles;
import com.iebm.aid.repository.AidFilesRepository;
import com.iebm.aid.service.AidFilesService;

@Service
public class AidFilesServiceImpl extends AbstractService<AidFiles, Long> implements AidFilesService{

	@Resource
	private AidFilesRepository repository;
	
	@Override
	protected BaseRepository<AidFiles, Long> getRepository() {
		return repository;
	}	
}
