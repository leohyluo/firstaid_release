package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.controller.req.KeyQParam;
import com.iebm.aid.pojo.KeyQ;
import com.iebm.aid.pojo.req.BasicKeyQ;
import com.iebm.aid.pojo.req.KeyQReq;
import com.iebm.aid.pojo.vo.KeyQVo;
import com.iebm.aid.pojo.vo.PlanResultVo;

public interface KeyQService extends BaseService<KeyQ, Long> {

	void decryptAll();
	
	/**
	 * 查询问题与答案
	 * @param mainId	主诉id
	 * @param curQuesNo	当前第几个问题
	 * @param answerId	当前问题的答案
	 * @return
	 */
	List<KeyQVo> questionAndAnswer(String mainId, Integer curQuesNo, String answerId);
	
	int getQuestionLen(String mainId);
	
	PlanResultVo getGradeAndPlan(KeyQReq req);
	
	List<KeyQVo> next(String mainId, Integer kqId, BasicKeyQ keyqUse);
	
	List<KeyQ> findByMainSymptomId(String mainSymptomId);
	
	List<KeyQVo> searchKeyQ(KeyQParam param);
}
