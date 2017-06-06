package com.iebm.aid.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.common.DataPool;
import com.iebm.aid.pojo.CacheKeyQ;
import com.iebm.aid.pojo.KqplanLink;
import com.iebm.aid.pojo.Plan;
import com.iebm.aid.pojo.vo.PlanVo;
import com.iebm.aid.repository.PlanRepository;
import com.iebm.aid.service.CacheKeyQService;
import com.iebm.aid.service.PlanService;
import com.iebm.aid.utils.CollectionUtils;
import com.iebm.aid.utils.StringUtils;

@Service
public class PlanServiceImpl extends AbstractService<Plan, Long> implements PlanService {

	@Resource
	private PlanRepository repository;
	@Resource
	private CacheKeyQService cacheKeyQService;
	
	@Override
	public void decryptAll() {
		/*Optional.of(this.findAll()).orElseGet(ArrayList::new).stream().peek(e->{
			e.setPlanTitle(EBMEnDecrypt.decrypt(e.getPlanTitle(), GlobalConstants.DECRYPT_CHARSET));
			e.setPlanContent(EBMEnDecrypt.decrypt(e.getPlanContent(), GlobalConstants.DECRYPT_CHARSET));
		}).collect(Collectors.toList());*/
	}
	
	@Override
	public void genPinyin() {
		/*this.findAll().stream().peek(e->e.setPinyin(PinyinUtils.getFirstPinYin(e.getPlanTitle())))
			.collect(Collectors.toList());*/
	}
	
	@Override
	//@Cacheable(value = "remote", key="'PlanServiceImpl.queryGravePlan'")
	public List<PlanVo> queryGravePlan() {
		List<String> planIds = Plan.GRAVE_PLANS;
		return repository.findByPlanIdIn(planIds).stream().map(PlanVo::new).collect(Collectors.toList());
	}
	

	@Override
	public List<PlanVo> queryByServerId(String serverId) {
		CacheKeyQ cacheKeyq = cacheKeyQService.findByServerId(serverId);
		String mainId = cacheKeyq.getSympID();
		List<KqplanLink> kqplanLinkList = DataPool.get(KqplanLink.class).stream().filter(e->{
			return e.getMainId().equals(mainId);
		}).collect(toList());
		
		Set<String> planIdSet = new HashSet<>();
		Set<String> replySet = findInReply(cacheKeyq, kqplanLinkList);
		Set<String> withoutReplySet = findWithoutReply(kqplanLinkList);
		planIdSet.addAll(replySet);
		planIdSet.addAll(withoutReplySet);
		List<String> planIdList = planIdSet.stream().collect(toList());
		
		List<PlanVo> voList = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(planIdList)) {
			findDefault(kqplanLinkList);
		}
		voList = repository.findByPlanIdIn(planIdList).stream().map(PlanVo::new).collect(toList());
		return voList;
	}

	@Override
	public Plan findByPlanId(String planId) {
		return repository.findByPlanId(planId);
	}

	@Override
	protected BaseRepository<Plan, Long> getRepository() {
		return repository;
	}
	
	/**
	 * 根据已回答的问题获取预案
	 * @param processKqIds
	 * @param processAnswerIds
	 * @param kqPlanLinkList
	 * @return
	 */
	private Set<String> findInReply(CacheKeyQ cacheKeyq, List<KqplanLink> kqPlanLinkList) {
		String processKqIds = cacheKeyq.getProcessKeyQIDs();
		String processAnswerIds = cacheKeyq.getProcessAnswerIDs();
		List<String> processKqIdList = Arrays.asList(processKqIds.split(",")).stream().collect(toList());
		List<String> processAnswerIdList = Arrays.asList(processAnswerIds.split(",")).stream().collect(toList());
		Set<String> planSet = new HashSet<>();
		//单个匹配
		for(int i=0; i<processKqIdList.size(); i++) {
			String processKqId = processKqIdList.get(i);
			String processAnswerId = processAnswerIdList.get(i);
			Set<String> matchSet = kqPlanLinkList.stream().filter(e->{
				return e.getKqId().equals(processKqId) && e.getAnswerId().equals(processAnswerId);
			}).map(e->e.getPlanId()).collect(Collectors.toSet());
			if(!matchSet.isEmpty()) {
				planSet.addAll(matchSet);
			}
		}
		
		//组合匹配(问题 3/6,答案 3/1)
		//key为已回答的问题id,value为已回答的答案id
		Map<String, String> kqanswerMap = new HashMap<>();
		for(int i=0; i<processKqIdList.size(); i++) {
			String kqId = processKqIdList.get(i);
			String answerId = processAnswerIdList.get(i);
			kqanswerMap.put(kqId, answerId);
		}
		//只处理带有/的预案规则
		List<KqplanLink> compositeKqPlanList = kqPlanLinkList.stream().filter(e->e.getKqId().contains("/"))
				.collect(toList());
		if(CollectionUtils.isNotEmpty(compositeKqPlanList)) {
			compositeKqPlanList.forEach(e->{
				String[] kqIdArr = e.getKqId().split("/");
				String[] answerIdArr = e.getAnswerId().split("/");
				boolean match = true;
				for(int i=0; i<kqIdArr.length; i++) {
					String kqId = kqIdArr[i];
					String answerId = answerIdArr[i];
					if(StringUtils.isEmpty(kqId) || StringUtils.isEmpty(answerId)) {
						continue;
					}
					String processAnswerId = kqanswerMap.get(kqId);
					if(!answerId.equals(processAnswerId)) {
						match = false;
						break;
					}
				}
				if(match) {
					planSet.add(e.getPlanId());
				}
			});
		}
		return planSet;
	}
	
	/**
	 * 获取与问题无关的预案
	 * @param kqPlanLinkList
	 * @return
	 */
	private Set<String> findWithoutReply(List<KqplanLink> kqPlanLinkList) {
		return kqPlanLinkList.stream().filter(e->{
			String answerId = e.getAnswerId();
			return StringUtils.isNotEmpty(answerId) && "0".equals(answerId);
		}).map(e->e.getPlanId()).collect(Collectors.toSet());
	}
	
	/**
	 * 获取默认的预案
	 * @param kqPlanLinkList
	 * @return
	 */
	private List<Plan> findDefault(List<KqplanLink> kqPlanLinkList) {
		return null;
	}

}
