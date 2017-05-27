package com.iebm.aid.service;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.MainSymptom;

public interface MainSymptomService extends BaseService<MainSymptom, Long> {

	void decryptAll();
	
	MainSymptom findByMainId(String mainId);
}
