package com.iebm.aid.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.Guide;
import com.iebm.aid.repository.GuideRepository;
import com.iebm.aid.service.GuideService;

@Service
public class GuideServiceImpl extends AbstractService<Guide, Long> implements GuideService{
	
	@Resource
	private GuideRepository repository;


	@Override
	public void decryptAll() {
		/*List<Guide> list = this.findAll();
		list.stream().peek(e->{
			e.setContent(EBMEnDecrypt.decrypt(e.getContent(), GlobalConstants.DECRYPT_CHARSET));
		}).collect(Collectors.toList());*/
	}
	
	@Override
	@Cacheable(value="remote", key="'guideServiceImpl.findDir3'")
	public List<String> findDir3() {
		return repository.groupByNameDir3();
	}
	

	@Override
	@Cacheable(value="remote", key="'guideServiceImpl.findByDir3.'+#dir3")
	public List<Guide> findByDir3(String dir3) {
		return repository.findByDir3(dir3);
	}
	
	@Override
	protected BaseRepository<Guide, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
