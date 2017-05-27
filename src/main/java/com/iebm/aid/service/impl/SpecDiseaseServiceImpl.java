package com.iebm.aid.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.SpecDisease;
import com.iebm.aid.pojo.vo.SpecDiseaseVo;
import com.iebm.aid.repository.SpecDiseaseRepository;
import com.iebm.aid.service.SpecDiseaseService;

@Service
public class SpecDiseaseServiceImpl extends AbstractService<SpecDisease, Long> implements SpecDiseaseService {

	@Resource
	private SpecDiseaseRepository repository;
	
	@Override
	public void decryptAll() {
		/*Optional.of(this.findAll()).orElseGet(ArrayList::new).stream().peek(e->{
			e.setDisIntro(EBMEnDecrypt.decrypt(e.getDisIntro(), GlobalConstants.DECRYPT_CHARSET));
			e.setDisDiagnosisBased(EBMEnDecrypt.decrypt(e.getDisDiagnosisBased(), GlobalConstants.DECRYPT_CHARSET));
			e.setDisTreatmentGuidelines(EBMEnDecrypt.decrypt(e.getDisTreatmentGuidelines(), GlobalConstants.DECRYPT_CHARSET));
			e.setDisOtherMeasures(EBMEnDecrypt.decrypt(e.getDisOtherMeasures(), GlobalConstants.DECRYPT_CHARSET));
		}).collect(Collectors.toList());*/
	}
	
	@Override
	public void genPinyin() {
		//this.findAll().stream().peek(e->e.setPingyin(PinyinUtils.getFirstPinYin(e.getDisName()))).collect(Collectors.toList());
	}

	@Override
	public List<SpecDiseaseVo> findVoBySysId(String sysId) {
		return Optional.of(repository.findBySysId(sysId)).orElseGet(ArrayList::new).stream().map(SpecDiseaseVo::new)
				.collect(Collectors.toList());
	}

	@Override
	public List<SpecDiseaseVo> findVoByKeyword(String keyword) {
		return Optional.of(repository.findByDisNameContainingOrPingyinContaining(keyword, keyword)).orElseGet(ArrayList::new).stream().map(SpecDiseaseVo::new)
				.collect(Collectors.toList());
	}

	@Override
	protected BaseRepository<SpecDisease, Long> getRepository() {
		return repository;
	}
}
