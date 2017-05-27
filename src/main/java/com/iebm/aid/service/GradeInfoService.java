package com.iebm.aid.service;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.GradeInfo;

public interface GradeInfoService extends BaseService<GradeInfo, Long> {

	void decryptAll();
}
