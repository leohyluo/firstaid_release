package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.SysDisease;

@Repository
public interface SysDiseaseRepository extends BaseRepository<SysDisease, Long> {

	List<SysDisease> findBySysId(Long sysId);
}
