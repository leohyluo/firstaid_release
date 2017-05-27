package com.iebm.aid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.Drug;

@Repository
public interface DrugRepository extends BaseRepository<Drug, Long> {

	@Query("select type0 from Drug group by type0 order by uniqId")
	List<String> groupByDrugType0();
	
	List<Drug> findByType0(String type0);
	
	List<Drug> findByName(String name);

	@Query("select name from Drug where name like %?1% or pingyin like %?2%")
	List<String> findByKeyword(String name, String pingyin);
}
