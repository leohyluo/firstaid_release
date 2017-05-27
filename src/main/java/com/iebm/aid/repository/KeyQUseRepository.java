package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.KeyQUse;

@Repository
public interface KeyQUseRepository extends BaseRepository<KeyQUse, Long> {

	List<KeyQUse> findByMainID(String mainId);
}
