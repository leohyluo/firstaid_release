package com.iebm.aid.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.MainSymptom;
import com.iebm.aid.repository.MainSympRepository;
import com.iebm.aid.service.MainSymptomService;

@Service
public class MainSymptomServiceImpl extends AbstractService<MainSymptom, Long> implements MainSymptomService{
	
	@Resource
	private MainSympRepository repository;


	@Override
	public void decryptAll() {
		/*List<MainSymptom> list = this.findAll();
		list.stream().peek(e->{
			e.setTitle(EBMEnDecrypt.decrypt(e.getTitle(), GlobalConstants.DECRYPT_CHARSET));
			e.setCode(EBMEnDecrypt.decrypt(e.getCode(), GlobalConstants.DECRYPT_CHARSET));
		}).collect(Collectors.toList());*/
	}
	
	@Override
	public MainSymptom findByMainId(String mainId) {
		return repository.findByMainId(mainId);
	}
	
	@Override
	protected BaseRepository<MainSymptom, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}


}
