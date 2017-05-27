package com.iebm.aid.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.KeyQ;

@Repository
public interface KeyQRepository extends BaseRepository<KeyQ, Long> {

	List<KeyQ> findByMainIDAndKqIDOrderByAnswerId(String mainId, Integer quesNo);
	
	List<KeyQ> findByMainIDAndKqIDAndAnswerIdOrderByAnswerId(String mainId, Integer quesNo, String answerId);
	
	@Query("from KeyQ order by kqID,answerId")
	List<KeyQ> findAllAndDefaultOrder();
	
	@Query("from KeyQ where mainID = ?1 and kqID in ?2 order by kqID,answerId")
	List<KeyQ> findByMainIdAndKqIds(String mainId, List<Integer> kqidList);
		
	@Query("select kqTitle from KeyQ where mainID = ?1 group by kqTitle")
	List<String> getQuestionLen(String mainId);
	
	List<KeyQ> findByMainIDOrderByKqID(String mainId);
	
	@Query("from KeyQ where mainID = ?1 group by kqTitle,answer order by kqID,answerId")
	List<KeyQ> findDistinctByMainID(String mainId);
	
	@Query("select min(kqID) from KeyQ where mainID = ?1 and kqID >= ?2 and kqID not in ?3 and (forwardFlag = '0' or forwardFlag = '0.0')")
	Integer findNextKqId(String mainId, Integer quesNo, Set<Integer> unmatchIds);
	
	@Query("select min(kqID) from KeyQ where mainID = ?1 and kqID > ?2 and kqID not in ?3 and (forwardFlag = '0' or forwardFlag = '0.0')")
	Integer findNextKqIdWithAnswerId(String mainId, Integer quesNo, Set<Integer> unmatchIds);
		
	@Query("select forwardId from KeyQ where mainID = ?1 and kqID = ?2 and answerId = ?3 ")
	String findForwardId(String mainId, Integer quesNo, String answerId);
}
