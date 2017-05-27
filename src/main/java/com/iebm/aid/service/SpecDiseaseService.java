package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.SpecDisease;
import com.iebm.aid.pojo.vo.SpecDiseaseVo;

public interface SpecDiseaseService extends BaseService<SpecDisease, Long> {

	void decryptAll();
	
	void genPinyin();
	
	List<SpecDiseaseVo> findVoBySysId(String sysId);
	
	List<SpecDiseaseVo> findVoByKeyword(String keyword);
	
}
