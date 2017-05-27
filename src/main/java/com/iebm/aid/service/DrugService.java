package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.Drug;

public interface DrugService extends BaseService<Drug, Long> {

	void decryptAll();
	
	void genPinyin();
	
	List<String> findDrugClass();
	
	List<String> findByType0(String type);
	
	Drug findByName(String name);
	
	List<String> findByKeyword(String keyword);
}
