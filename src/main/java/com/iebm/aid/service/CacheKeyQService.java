package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.controller.req.BasicInfoReq;
import com.iebm.aid.pojo.CacheKeyQ;
import com.iebm.aid.pojo.vo.KeyQVo;

public interface CacheKeyQService extends BaseService<CacheKeyQ, Long> {

	List<KeyQVo> getFirstKeyQ(BasicInfoReq basicInfo, String serverId);
	
	CacheKeyQ findByServerId(String serverId);
}
