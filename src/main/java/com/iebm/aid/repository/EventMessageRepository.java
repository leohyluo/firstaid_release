package com.iebm.aid.repository;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.EventMessage;


@Repository
public interface EventMessageRepository extends BaseRepository<EventMessage, Long> {

	
}
