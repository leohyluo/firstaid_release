package com.iebm.aid.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.SysDisease;
import com.iebm.aid.repository.SysDiseaseRepository;
import com.iebm.aid.service.SysDiseaseService;

@Service
public class SysDiseaseServiceImpl extends AbstractService<SysDisease, Long> implements SysDiseaseService {

	@Resource
	private SysDiseaseRepository repository;
	
	@Override
	protected BaseRepository<SysDisease, Long> getRepository() {
		return repository;
	}

	@Override
	public List<SysDisease> findBySysId(Long sysId) {
		return repository.findBySysId(sysId);
	}
}
