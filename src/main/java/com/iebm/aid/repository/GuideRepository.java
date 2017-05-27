package com.iebm.aid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.Guide;

@Repository
public interface GuideRepository extends BaseRepository<Guide, Long> {

	@Query("select dir3 from Guide group by dir3 order by uniqId")
	List<String> groupByNameDir3();
	
	List<Guide> findByDir3(String dir3);
}
