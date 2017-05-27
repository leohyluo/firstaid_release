package com.iebm.aid.service;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.MainKeyQ;

public interface MainKeyQService extends BaseService<MainKeyQ, Long> {

	void decryptAll();
}
