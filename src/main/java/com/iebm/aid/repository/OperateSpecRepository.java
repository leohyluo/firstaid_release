package com.iebm.aid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.OperateSpec;

@Repository
public interface OperateSpecRepository extends BaseRepository<OperateSpec, Long> {

	@Query("select dir2 from OperateSpec group by dir2 order by _id")
	List<String> groupByDir2();
		
	List<OperateSpec> findByDir2OrderById(String dir2Name);
		
}
