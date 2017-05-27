package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.OperateSpec;
import com.iebm.aid.pojo.vo.OperateSpecVo;

public interface OperateSpecService extends BaseService<OperateSpec, Long> {

	void decryptAll();
	
	List<String> groupByDir2();
	
	List<OperateSpecVo> findByDir2(String dir2);
}
