package com.iebm.aid.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.MainKeyQ;
import com.iebm.aid.repository.MainKeyQRepository;
import com.iebm.aid.service.MainKeyQService;

@Service
public class MainKeyQServiceImpl extends AbstractService<MainKeyQ, Long> implements MainKeyQService{
	
	@Resource
	private MainKeyQRepository repository;


	@Override
	public void decryptAll() {
		/*List<MainKeyQ> list = this.findAll();
		list.stream().peek(e->{
			e.setTitle(EBMEnDecrypt.decrypt(e.getTitle(),"GBK"));
			e.setProExplain(EBMEnDecrypt.decrypt(e.getProExplain(), GlobalConstants.DECRYPT_CHARSET));
			e.setAnswer(EBMEnDecrypt.decrypt(e.getAnswer(), GlobalConstants.DECRYPT_CHARSET));
			e.setAnswerExplain(EBMEnDecrypt.decrypt(e.getAnswerExplain(), GlobalConstants.DECRYPT_CHARSET));
		}).collect(Collectors.toList());*/
	}
	
	@Override
	protected BaseRepository<MainKeyQ, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}


}
