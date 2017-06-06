package com.iebm.aid.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.OperateSpec;
import com.iebm.aid.pojo.vo.OperateSpecVo;
import com.iebm.aid.repository.OperateSpecRepository;
import com.iebm.aid.service.OperateSpecService;

@Service
public class OperateSpecServiceImpl extends AbstractService<OperateSpec, Long> implements OperateSpecService {

	@Resource
	private OperateSpecRepository repository;
	
	@Override
	public void decryptAll() {
		/*Optional.ofNullable(this.findAll()).orElseGet(ArrayList::new).stream().peek(e->{
			e.setOverview(EBMEnDecrypt.decrypt(e.getOverview(), GlobalConstants.DECRYPT_CHARSET));
			e.setIndication(EBMEnDecrypt.decrypt(e.getIndication(), GlobalConstants.DECRYPT_CHARSET));
			e.setContraindications(EBMEnDecrypt.decrypt(e.getContraindications(), GlobalConstants.DECRYPT_CHARSET));
			e.setOperationPlan(EBMEnDecrypt.decrypt(e.getOperationPlan(), GlobalConstants.DECRYPT_CHARSET));
			e.setOperationMethod(EBMEnDecrypt.decrypt(e.getOperationMethod(), GlobalConstants.DECRYPT_CHARSET));
			e.setAnnouncements(EBMEnDecrypt.decrypt(e.getAnnouncements(), GlobalConstants.DECRYPT_CHARSET));
			e.setSyndrome(EBMEnDecrypt.decrypt(e.getSyndrome(), GlobalConstants.DECRYPT_CHARSET));
		}).collect(Collectors.toList()); */
	}
	
	@Override
	//@Cacheable(value = "remote", key="'operateSpecServiceImpl.groupByDir2'")
	public List<String> groupByDir2() {
		return repository.groupByDir2();
	}
	
	@Override
	public List<OperateSpecVo> findByDir2(String dir2) {
		return Optional.of(repository.findByDir2OrderById(dir2)).orElseGet(ArrayList::new).stream().map(OperateSpecVo::new)
				.collect(Collectors.toList());
	}

	@Override
	protected BaseRepository<OperateSpec, Long> getRepository() {
		return repository;
	}

}
