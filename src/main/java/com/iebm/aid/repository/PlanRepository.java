package com.iebm.aid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.Plan;

@Repository
public interface PlanRepository extends BaseRepository<Plan, Long> {

	@Query("from Plan where planId in ?1 order by field(planId, ?2)")
	List<Plan> findByPlanIdIn(List<String> planIdList, String planIds);
	
	List<Plan> findByPlanIdIn(List<String> planIdList);
	
	Plan findByPlanId(String planId);
}
