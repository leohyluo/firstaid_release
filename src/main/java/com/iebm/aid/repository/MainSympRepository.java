package com.iebm.aid.repository;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.MainSymptom;

@Repository
public interface MainSympRepository extends BaseRepository<MainSymptom, Long> {

	MainSymptom findByMainId(String mainId);
}
