package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.KeyQUse;

public interface KeyQUseService extends BaseService<KeyQUse, Long> {

	List<KeyQUse> findByMainSymptomId(String mainSymptomId);
}
