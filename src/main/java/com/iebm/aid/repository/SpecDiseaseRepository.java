package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.SpecDisease;

@Repository
public interface SpecDiseaseRepository extends BaseRepository<SpecDisease, Long> {

	List<SpecDisease> findBySysId(String sysId);
	
	List<SpecDisease> findByDisNameContainingOrPingyinContaining(String disName, String pingyin);
		
}
