package com.iebm.aid.service;

import java.util.List;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.Plan;
import com.iebm.aid.pojo.vo.PlanVo;

public interface PlanService extends BaseService<Plan, Long> {

	void decryptAll();
	
	void genPinyin();
	
	/**
	 * 获取紧急预案
	 * @return
	 */
	List<PlanVo> queryGravePlan();
	
	/**
	 * 根据问诊过程生成预案
	 * @param serverId
	 * @return
	 */
	List<PlanVo> queryByServerId(String serverId);
	
	/**
	 * 查看预案详情
	 * @param planId
	 * @return
	 */
	Plan findByPlanId(String planId);
}
