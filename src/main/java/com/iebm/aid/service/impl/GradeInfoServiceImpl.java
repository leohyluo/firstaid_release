package com.iebm.aid.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.GradeInfo;
import com.iebm.aid.repository.GradeInfoRepository;
import com.iebm.aid.service.GradeInfoService;

@Service
public class GradeInfoServiceImpl extends AbstractService<GradeInfo, Long> implements GradeInfoService{
	
	@Resource
	private GradeInfoRepository repository;


	@Override
	public void decryptAll() {
		/*List<GradeInfo> list = this.findAll();
		list.stream().peek(e->{
			e.setGradName(EBMEnDecrypt.decrypt(e.getGradName(), GlobalConstants.DECRYPT_CHARSET));
			e.setResult(EBMEnDecrypt.decrypt(e.getResult(), GlobalConstants.DECRYPT_CHARSET));
			e.setRemark(EBMEnDecrypt.decrypt(e.getRemark(), GlobalConstants.DECRYPT_CHARSET));
		}).collect(Collectors.toList());*/
	}
	
	@Override
	protected BaseRepository<GradeInfo, Long> getRepository() {
		return repository;
	}
}
