package com.iebm.aid.service;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.CacheKeyQ;
import com.iebm.aid.pojo.Mpds;

public interface MpdsService extends BaseService<Mpds, Long> {

	/**
	 * 根据已选择的问题与答案中获取最高级别的患者病情
	 * @param cacheKeyq
	 * @return
	 */
	Mpds findMpdsGrade(CacheKeyQ cacheKeyq);
}
