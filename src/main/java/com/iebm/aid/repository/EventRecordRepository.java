package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.EventRecord;


@Repository
public interface EventRecordRepository extends BaseRepository<EventRecord, Long> {

	List<EventRecord> findByEventNo(String eventNo);
	
}
