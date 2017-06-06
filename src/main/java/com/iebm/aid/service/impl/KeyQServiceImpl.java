package com.iebm.aid.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.common.DataPool;
import com.iebm.aid.controller.req.KeyQParam;
import com.iebm.aid.pojo.CacheKeyQ;
import com.iebm.aid.pojo.KeyQ;
import com.iebm.aid.pojo.KeyQUse;
import com.iebm.aid.pojo.KqplanLink;
import com.iebm.aid.pojo.Mpds;
import com.iebm.aid.pojo.Plan;
import com.iebm.aid.pojo.req.BasicKeyQ;
import com.iebm.aid.pojo.req.KeyQReq;
import com.iebm.aid.pojo.vo.KeyQVo;
import com.iebm.aid.pojo.vo.PlanResultVo;
import com.iebm.aid.pojo.vo.PlanVo;
import com.iebm.aid.repository.KeyQRepository;
import com.iebm.aid.repository.KeyQUseRepository;
import com.iebm.aid.repository.KqplanLinkRepository;
import com.iebm.aid.repository.MpdsRepository;
import com.iebm.aid.repository.PlanRepository;
import com.iebm.aid.service.CacheKeyQService;
import com.iebm.aid.service.KeyQService;
import com.iebm.aid.utils.StringUtils;

@Transactional
@Service
public class KeyQServiceImpl extends AbstractService<KeyQ, Long> implements KeyQService{
	
	private static final String NEXT = "next";
	private static final String PREV = "prev";
	
	@Resource
	private KeyQRepository repository;
	@Resource
	private MpdsRepository mpdsRepository;
	@Resource
	private KqplanLinkRepository kqplanLinkRepository;
	@Resource
	private PlanRepository planRepository; 
	@Resource
	private KeyQUseRepository keyQUseRepository;
	@Resource
	private CacheKeyQService cacheKeyQService;

	@Override
	public void decryptAll() {
		/*this.findAll().stream().peek(e->{
			e.setKqTitle(EBMEnDecrypt.decrypt(e.getKqTitle(), GlobalConstants.DECRYPT_CHARSET));
			e.setCommExplain(EBMEnDecrypt.decrypt(e.getCommExplain(), GlobalConstants.DECRYPT_CHARSET));
			e.setAnswer(EBMEnDecrypt.decrypt(e.getAnswer(), GlobalConstants.DECRYPT_CHARSET));
			e.setAnswerExplain(EBMEnDecrypt.decrypt(e.getAnswerExplain(), GlobalConstants.DECRYPT_CHARSET));
		}).collect(Collectors.toList());*/
	}
	
	@Override
	public List<KeyQVo> questionAndAnswer(String mainId, Integer curQuesNo, String answerId) {
		List<KeyQVo> list = new ArrayList<>();
 		if(StringUtils.isEmpty(answerId)) { 			
			list = Optional.ofNullable(repository.findByMainIDAndKqIDOrderByAnswerId(mainId, curQuesNo)).orElseGet(ArrayList::new)
					.stream().map(KeyQVo::new).collect(Collectors.toList()); 
		} else {
			Optional<KeyQ> optionalVal = Optional.ofNullable(repository.findByMainIDAndKqIDAndAnswerIdOrderByAnswerId(mainId, curQuesNo, answerId)).orElseGet(ArrayList::new)
				.stream().filter(e->!StringUtils.isEmpty(e.getForwardId())).findFirst();
						
			if(optionalVal.isPresent()) {
				KeyQ keyq = optionalVal.get();				
				list = questionAndAnswer(mainId, Integer.parseInt(keyq.getForwardId()), null);
			} else {
				int quesNo = curQuesNo + 1;
				list = questionAndAnswer(mainId, quesNo, null);
			}
		}
		return list;
	}
	
	@Override
	public int getQuestionLen(String mainId) {
		return repository.getQuestionLen(mainId).size();
	}
	
	@Override
	public PlanResultVo getGradeAndPlan(KeyQReq req) {
		List<KeyQ> keyqList = repository.findByMainIDOrderByKqID(req.getMainId());
		List<KqplanLink> kqplanList = kqplanLinkRepository.findByMainId(req.getMainId());
		
		String[] questionArr = req.getQuestionNos().split(",");
		String[] answerArr = req.getAnswerIds().split(",");
		if(questionArr.length != answerArr.length) {
			return null;
		}
		//存储危急分级
		Set<String> set = new HashSet<>();
		//存储处置预案id以及预案出现的次数<planId,planId出现的次数>
		Map<String, Integer> planMap = new HashMap<>();
		Consumer<KeyQ> consumer = (e)->{
			set.add(e.getMpdsId());
		};
		
		for(int i = 0; i < questionArr.length; i++) {
			String questionNo = questionArr[i];
			String answerId = answerArr[i];
			//查询每个答案对应的危急分级,并将分级存放至set中
			Optional<KeyQ> optionalKeyq = keyqList.stream().filter(e->e.getKqID() == Integer.parseInt(questionNo)).
					filter(e->e.getAnswerId().equals(answerId)).filter(e->!StringUtils.isEmpty(e.getMpdsId())).findAny();
			optionalKeyq.ifPresent(consumer);
			//获取每个答案对应的处置预案id,并将其存放至map中
			List<KqplanLink> itemKqplanLit = Optional.of(kqplanList).orElseGet(ArrayList::new).stream().filter(e->e.getKqId().equals(questionNo))
				.filter(e->e.getAnswerId().equals(answerId)).collect(Collectors.toList());
			for(KqplanLink item : itemKqplanLit) {
				if(planMap.containsKey(item.getPlanId())) {
					int count = planMap.get(item.getPlanId());
					planMap.put(item.getPlanId(), ++count);
				} else {
					planMap.put(item.getPlanId(), 1);
				}
			}
		}
		String explain = "";
		//获取最高级别的危急分级
		Optional<String> optionGrade = set.stream().sorted().findFirst();
		if(optionGrade.isPresent()) {
			String flag = optionGrade.get();
			List<Mpds> mpdsList = mpdsRepository.findByFlag(flag);
			if(!CollectionUtils.isEmpty(mpdsList)) {
				Mpds mpds = mpdsList.get(0);
				explain = mpds.getExplain();
			}
		}
		//将planId出现次数最多的排前面
		Map<String, Integer> sortMap = new LinkedHashMap<>();
		planMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
			.forEachOrdered(e->sortMap.put(e.getKey(), e.getValue()));
		List<String> planIdList = sortMap.keySet().stream().collect(Collectors.toList());
		String planIds = "";
		for(String str : planIdList) {
			planIds += str + ",";
		}
		planIds = planIds.length() > 0 ? planIds.substring(0, planIds.length() - 1) : planIds;
		List<Plan> planList = new ArrayList<>();
		if(!StringUtils.isEmpty(planIds)) {
			planList = planRepository.findByPlanIdIn(planIdList, planIds);
		}
		
		List<PlanVo> planvoList = Optional.of(planList).orElseGet(ArrayList::new)
				.stream().map(PlanVo::new).collect(Collectors.toList());
		return new PlanResultVo(explain, planvoList);
	}
	
	@Override
	public List<KeyQVo> next(String mainId, Integer kqId, BasicKeyQ keyqUse) {
		List<KeyQUse> keyQUseList = keyQUseRepository.findByMainID(mainId);
		String answerId = keyqUse.getAnswerId();
		String age = keyqUse.getAge();
		String gender = keyqUse.getGender();
		/*String callType = keyqUse.getCallType();
		String hasAware = keyqUse.getHasAware();
		String hasBreath = keyqUse.getHasBreath();*/
		
		Set<String> allSet = keyQUseList.stream().map(e->e.getKqID()).collect(Collectors.toSet());			
		Set<String> matchSet = new HashSet<>();
		matchSet.addAll(agePredicate(keyQUseList, age));
		matchSet.addAll(genderPredicate(keyQUseList, gender));
		//去掉符合条件的剩下的都是不符合条件的
		allSet.removeAll(matchSet);
		if(CollectionUtils.isEmpty(allSet)) {
			allSet.add("-1");
		}
		Set<Integer> filterSet = allSet.stream().map(Integer::parseInt).collect(Collectors.toSet());
		
		List<KeyQ> list = new ArrayList<>(); 
		if(StringUtils.isEmpty(answerId)) {
			Integer nextKqId = repository.findNextKqId(mainId, kqId, filterSet);
			list = repository.findByMainIDAndKqIDOrderByAnswerId(mainId, nextKqId);			
		} else {
			String forwardId = repository.findForwardId(mainId, kqId, answerId);
			if(StringUtils.isEmpty(forwardId)) {
				Integer nextKqId = repository.findNextKqIdWithAnswerId(mainId, kqId, filterSet);
				list = repository.findByMainIDAndKqIDOrderByAnswerId(mainId, nextKqId);
			} else {
				Integer nextKqId = Integer.parseInt(forwardId);
				list = repository.findByMainIDAndKqIDOrderByAnswerId(mainId, nextKqId);	
			}
		}
		return list.stream().map(KeyQVo::new).collect(Collectors.toList());
		
	}

	@Override
	public List<KeyQ> findByMainSymptomId(String mainSymptomId) {
		return repository.findByMainIDOrderByKqID(mainSymptomId);
	}

	@Override
	public List<KeyQVo> searchKeyQ(KeyQParam param) {
		String serverId = param.getServerId();
		String type = param.getType();
		
		CacheKeyQ cacheKeyq = cacheKeyQService.findByServerId(serverId);
		if(cacheKeyq == null) {
			return null;
		}
		String mainId = cacheKeyq.getSympID();
		
		if(NEXT.equalsIgnoreCase(type)) {
			return nextKeyQ(mainId, param, cacheKeyq);
		} else if (PREV.equalsIgnoreCase(type)) {
			return prevKeyQ(mainId, param, cacheKeyq);
		}
		return null;
	}
		
	@Override
	protected BaseRepository<KeyQ, Long> getRepository() {
		return repository;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private List<KeyQVo> nextKeyQ(String mainId, KeyQParam param, CacheKeyQ cacheKeyq) {
		
		int inputKqId = Integer.parseInt(param.getKqId());
		String inputAnswerId = param.getAnswerId();
		String standareKqIds = cacheKeyq.getAllKeyQIDs();
		String[] arr = standareKqIds.split(",");
		List<Integer> kqidList = Arrays.asList(arr).stream().map(Integer::parseInt).collect(Collectors.toList());
		
		Predicate<KeyQ> kqIdPredicate = (e)->{
			boolean contains = false;
			for(Integer defaultKqId : kqidList) {
				if(defaultKqId == e.getKqID()) {
					contains = true;
					break;
				}
			}
			return contains;
		};
		
		//List<KeyQ> allKeyqList = repository.findByMainIdAndKqIds(mainId, kqidList);
		List<KeyQ> allKeyqList = DataPool.get(KeyQ.class).stream().filter(e->e.getMainID().equals(mainId))
				.filter(kqIdPredicate).collect(Collectors.toList());
		
				
		if(CollectionUtils.isEmpty(allKeyqList)) {
			return null;
		}
		int lastKqId = allKeyqList.stream().sorted((e1, e2)->e2.getKqID().compareTo(e1.getKqID())).map(e->e.getKqID()).findFirst().get();
		if(inputKqId == lastKqId) {
			return null;
		}
		String forwardId = "";
		Optional<KeyQ> optional = allKeyqList.stream().filter(e->e.getKqID() == inputKqId).filter(e->e.getAnswerId().equals(inputAnswerId)).findFirst();
		if(optional.isPresent()) {
			forwardId = optional.get().getForwardId();
		}
		
		List<KeyQVo> voList = new ArrayList<>();
		
		if(StringUtils.isNotEmpty(forwardId)) {
			Integer nextKqId = Integer.parseInt(forwardId);
			voList = allKeyqList.stream().filter(e->e.getKqID()==nextKqId).map(KeyQVo::new).collect(Collectors.toList());				
		} else {
			Map<Integer, List<KeyQ>> map = allKeyqList.stream().filter(e->e.getKqID() > inputKqId)
					.filter(e->!e.getForwardFlag().contains("1"))
					.collect(Collectors.groupingBy(KeyQ::getKqID));
			Integer nextKqId = map.keySet().stream().sorted(Integer::compareTo).findFirst().get();
			voList = allKeyqList.stream().filter(e->e.getKqID()==nextKqId).map(KeyQVo::new).collect(Collectors.toList());
		}
		String processKqIds = StringUtils.isEmpty(cacheKeyq.getProcessKeyQIDs()) ? String.valueOf(inputKqId) : cacheKeyq.getProcessKeyQIDs() + "," + inputKqId;
		String processAnswerIds = StringUtils.isEmpty(cacheKeyq.getProcessAnswerIDs()) ? String.valueOf(inputAnswerId) : cacheKeyq.getProcessAnswerIDs() + "," + inputAnswerId;
		
		cacheKeyq.setProcessKeyQIDs(processKqIds);
		cacheKeyq.setProcessAnswerIDs(processAnswerIds);
		cacheKeyQService.save(cacheKeyq);
		return voList;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private List<KeyQVo> prevKeyQ(String mainId, KeyQParam param, CacheKeyQ cacheKeyq) {
		String inputKqId = param.getKqId();
		
		final int prevKqId = getPrevKqId(cacheKeyq, Integer.parseInt(inputKqId));	
		//List<KeyQ> list = repository.findByMainIDAndKqIDOrderByAnswerId(mainId, Integer.parseInt(prevKqId));
		List<KeyQ> list = DataPool.get(KeyQ.class).stream().filter(e->e.getMainID().equals(mainId))
				.filter(e->e.getKqID() == prevKqId).collect(Collectors.toList());
		List<KeyQVo> voList = list.stream().map(KeyQVo::new).collect(Collectors.toList());
		//更新已回答的问题序号
		updateCacheKeyqWhenPrev(cacheKeyq, prevKqId);
		return voList;
	}
	
	private Set<String> agePredicate(List<KeyQUse> useList, String inputAge) {
		Set<String> matchSet = new HashSet<>();
		for(KeyQUse item : useList) {
			if(StringUtils.isNotEmpty(item.getAge())) {
				if(StringUtils.isNotEmpty(inputAge) && inputAge.equals(item.getAge())) {
					matchSet.add(item.getKqID());
				}
			} else {
				matchSet.add(item.getKqID());
			}
		}
		return matchSet;
	}
	
	private Set<String> genderPredicate(List<KeyQUse> useList, String inputGender) {
		Set<String> matchSet = new HashSet<>();
		for(KeyQUse item : useList) {
			if(!StringUtils.isEmpty(item.getGender())) {
				if(StringUtils.isNotEmpty(inputGender) && inputGender.equals(item.getGender())) {
					matchSet.add(item.getKqID());
				}
			} else {
				matchSet.add(item.getKqID());
			}
		}
		return matchSet;
	}

	private Integer getPrevKqId(CacheKeyQ cacheKeyq, Integer kqId) {
		String processKqIds = cacheKeyq.getProcessKeyQIDs();
		int prevKqId = Arrays.asList(processKqIds.split(",")).stream().mapToInt(Integer::parseInt).filter(e->e<kqId).max().getAsInt();
		return prevKqId;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private void updateCacheKeyqWhenPrev(CacheKeyQ cacheKeyq, Integer kqId) {
		String processKqIds = cacheKeyq.getProcessKeyQIDs();
		String processAnswerIds = cacheKeyq.getProcessAnswerIDs();
		
		List<Integer> kqIdList = Arrays.asList(processKqIds.split(",")).stream().map(Integer::parseInt)
				.filter(e->e < kqId).collect(Collectors.toList()); 
		List<Integer> answerIdList = Arrays.asList(processAnswerIds.split(",")).stream().map(Integer::parseInt)
				.collect(Collectors.toList());
		answerIdList = answerIdList.subList(0, kqIdList.size());
		
		StringJoiner kqIdJoiner = new StringJoiner(",");
		StringJoiner answerIdJoiner = new StringJoiner(",");
		kqIdList.forEach(e->kqIdJoiner.add(String.valueOf(e)));
		answerIdList.forEach(e->answerIdJoiner.add(String.valueOf(e)));
		
		processKqIds = kqIdJoiner.toString();
		processAnswerIds = answerIdJoiner.toString();
		
		cacheKeyq.setProcessKeyQIDs(processKqIds);
		cacheKeyq.setProcessAnswerIDs(processAnswerIds);
		cacheKeyQService.save(cacheKeyq);
	}
}
