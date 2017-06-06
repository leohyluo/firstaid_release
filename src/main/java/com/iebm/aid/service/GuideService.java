package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.Guide;
import com.iebm.aid.pojo.vo.GuideVo;

public interface GuideService extends BaseService<Guide, Long> {

	void decryptAll();
	
	List<String> findDir3();
	
	List<GuideVo> findByDir3(String dir3);
}
