package com.iebm.aid.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.Drug;
import com.iebm.aid.repository.DrugRepository;
import com.iebm.aid.service.DrugService;

@Service
public class DrugServiceImpl extends AbstractService<Drug, Long> implements DrugService{
	
	@Resource
	private DrugRepository repository;


	@Override
	public void decryptAll() {
		/*List<Drug> list = this.findAll();
		list.stream().peek(e->{
			e.setNorm(EBMEnDecrypt.decrypt(e.getNorm(), GlobalConstants.DECRYPT_CHARSET));
			e.setDosage(EBMEnDecrypt.decrypt(e.getDosage(), GlobalConstants.DECRYPT_CHARSET));
			e.setPrecautions(EBMEnDecrypt.decrypt(e.getPrecautions(), GlobalConstants.DECRYPT_CHARSET));
			e.setSideEffect(EBMEnDecrypt.decrypt(e.getSideEffect(), GlobalConstants.DECRYPT_CHARSET));
			e.setIndications(EBMEnDecrypt.decrypt(e.getIndications(), GlobalConstants.DECRYPT_CHARSET));
			e.setContraindications(EBMEnDecrypt.decrypt(e.getContraindications(), GlobalConstants.DECRYPT_CHARSET));
		}).collect(Collectors.toList());*/
	}
	
	@Override
	@Cacheable(value="remote", key="'drugServiceImpl.findDrugClass'")
	public List<String> findDrugClass() {
		return repository.groupByDrugType0();
	}
	
	@Override
	public List<String> findByKeyword(String keyword) {
		return repository.findByKeyword(keyword, keyword);
	}
	

	@Override
	@Cacheable(value="remote", key="'drugServiceImpl.findByType0.'+#type")
	public List<String> findByType0(String type) {
		return Optional.of(repository.findByType0(type)).orElseGet(ArrayList::new).stream().map(e->e.getName())
				.collect(Collectors.toList());
	}

	@Override
	public Drug findByName(String name) {
		return Optional.ofNullable(repository.findByName(name)).orElseGet(ArrayList::new).stream().findFirst().orElseGet(null);
	}
	
	@Override
	public void genPinyin() {
		//this.findAll().stream().peek(e->e.setPingyin(PinyinUtils.getFirstPinYin(e.getName()))).collect(Collectors.toList());
	}
	
	@Override
	protected BaseRepository<Drug, Long> getRepository() {
		return repository;
	}
}
