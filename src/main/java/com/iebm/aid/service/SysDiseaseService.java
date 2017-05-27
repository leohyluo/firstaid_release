package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.SysDisease;

public interface SysDiseaseService extends BaseService<SysDisease, Long> {

	List<SysDisease> findBySysId(Long sysId);
}
