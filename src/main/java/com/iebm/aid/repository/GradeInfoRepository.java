package com.iebm.aid.repository;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.GradeInfo;

@Repository
public interface GradeInfoRepository extends BaseRepository<GradeInfo, Long> {
	
}
