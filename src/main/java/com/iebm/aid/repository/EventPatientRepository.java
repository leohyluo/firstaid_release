package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.EventPatient;


@Repository
public interface EventPatientRepository extends BaseRepository<EventPatient, Long> {

	List<EventPatient> findByEventNo(String eventNo);
	
}
