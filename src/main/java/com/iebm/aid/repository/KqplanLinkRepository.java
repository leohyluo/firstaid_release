package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.KqplanLink;

@Repository
public interface KqplanLinkRepository extends BaseRepository<KqplanLink, Long> {

	List<KqplanLink> findByMainId(String mainId);
}
