package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.Mpds;

@Repository
public interface MpdsRepository extends BaseRepository<Mpds, Long> {

	List<Mpds> findByFlag(String flag);
}
