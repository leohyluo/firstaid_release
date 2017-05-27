package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.CacheKeyQ;

@Repository
public interface CacheKeyQRepository extends BaseRepository<CacheKeyQ, Long> {

	List<CacheKeyQ> findByServerId(String serverId);
}
