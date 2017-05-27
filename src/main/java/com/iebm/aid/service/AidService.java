package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.pojo.KeyQ;
import com.iebm.aid.pojo.KeyQUse;

public interface AidService {

	List<KeyQ> findByMainId(String mainId);
	
	List<KeyQUse> findKeyQUseByMainId(String mainId);
}
