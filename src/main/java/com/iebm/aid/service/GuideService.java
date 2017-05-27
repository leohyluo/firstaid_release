package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.Guide;

public interface GuideService extends BaseService<Guide, Long> {

	void decryptAll();
	
	List<String> findDir3();
	
	List<Guide> findByDir3(String dir3);
}
