package com.iebm.aid.service.impl;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.common.DataPool;
import com.iebm.aid.controller.req.BasicInfoReq;
import com.iebm.aid.controller.req.SearchAidFilesParam;
import com.iebm.aid.pojo.AidFiles;
import com.iebm.aid.pojo.AidRecord;
import com.iebm.aid.pojo.CacheKeyQ;
import com.iebm.aid.pojo.KeyQ;
import com.iebm.aid.pojo.MainSymptom;
import com.iebm.aid.pojo.vo.AidRecordDetailVo;
import com.iebm.aid.pojo.vo.AidRecordVo;
import com.iebm.aid.pojo.vo.PlanVo;
import com.iebm.aid.repository.AidRecordRepository;
import com.iebm.aid.service.AidFilesService;
import com.iebm.aid.service.AidRecordService;
import com.iebm.aid.service.CacheKeyQService;
import com.iebm.aid.service.MainSymptomService;
import com.iebm.aid.utils.CollectionUtils;


@Service
@Transactional
public class AidRecordServiceImpl extends AbstractService<AidRecord, Long> implements AidRecordService {

	@Resource
	private AidRecordRepository repository;
	@Resource
	private AidFilesService aidFilesService;
	@Resource
	private CacheKeyQService cacheKeyQService;
	@Resource
	private MainSymptomService mainSymptomService;
	

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Long saveAidFiles(AidFiles aidFiles) {
		if(aidFiles == null) {
			aidFiles = new AidFiles();
		}
		aidFiles.setCreateTime(LocalDateTime.now());
		aidFiles.setLastupdTime(LocalDateTime.now());
		aidFilesService.save(aidFiles);
		return aidFiles.getId();
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveAidRecord(String serverId, List<PlanVo> planvoList) {
		BasicInfoReq basicInfo = DataPool.take(serverId, BasicInfoReq.class);
		if(basicInfo == null) {
			return;
		}
		CacheKeyQ cacheKeyq = cacheKeyQService.findByServerId(serverId);
		AidFiles aidFiles = basicInfo.parseToAidFiles();
		Long filesId = this.saveAidFiles(aidFiles);	//急救档案id
		
		MainSymptom mainSymptom = mainSymptomService.findByMainId(cacheKeyq.getSympID());
		StringJoiner joiner = new StringJoiner(",");
		if(CollectionUtils.isNotEmpty(planvoList)) {
			planvoList.stream().map(PlanVo::getPlanId).collect(toList()).stream().forEach(e->joiner.add(e));
		}
		String mainSymptomText = mainSymptom.getTitle();
		String cureProcess = parseToProcessText(cacheKeyq.getSympID(), cacheKeyq.getProcessKeyQIDs(),
				cacheKeyq.getProcessAnswerIDs());
		AidRecord aidRecord = basicInfo.parseToAidRecord();
		aidRecord.setFilesId(filesId.toString());
		aidRecord.setMainSymptomText(mainSymptomText);
		aidRecord.setCureProcess(cureProcess);
		aidRecord.setPlanIds(joiner.toString());
		aidRecord.setCreateTime(LocalDateTime.now());
		save(aidRecord);
	}

	@Override
	public List<AidRecordVo> search(SearchAidFilesParam param) {
		LocalDateTime startTime = null;
		LocalDateTime endTime = LocalDateTime.now();
		String type = param.getType();
		if("1".equals(type)) {
			startTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);			
		} else if ("2".equals(type)) {
			startTime = LocalDateTime.now().plusDays(-7).withHour(0).withMinute(0).withSecond(0);
		} else if ("3".equals(type)) {
			startTime = LocalDateTime.now().plusMonths(-1).withHour(0).withMinute(0).withSecond(0);
		} else if ("4".equals(type)) {
			startTime = LocalDateTime.parse(param.getStartTime());
			endTime = LocalDateTime.parse(param.getEndTime());
		} 
		List<AidRecord> recordList = repository.findByCreateTimeBetween(startTime, endTime);
		return recordList.stream().map(AidRecordVo::new).collect(toList());
	}
	
	@Override
	public Page<AidRecordVo> findByPage(SearchAidFilesParam param) {
		Sort sortObj;
		if (!StringUtils.isEmpty(param.getOrder()) && !StringUtils.isEmpty(param.getSort())) {
			sortObj = new Sort(new Order(param.getOrder().toUpperCase().equals("ASC") ? Direction.ASC : Direction.DESC, param.getSort())).and(new Sort(
					new Order(Direction.ASC, "id")));
		} else {
			sortObj = new Sort(new Order(Direction.ASC, "id"));
		}
		
		
		
		Pageable pageable = new PageRequest(param.getPage(), param.getRows(), sortObj);
		Specification<AidRecord> spec = new Specification<AidRecord>() {
			LocalDateTime startTime = null;
			LocalDateTime endTime = LocalDateTime.now();
			String type = param.getType();
			
			@Override
			public Predicate toPredicate(Root<AidRecord> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> ps = new ArrayList<Predicate>();
				/*if (!StringUtils.isEmpty(t.getPhones())) {
					String mobile = StringVerifyUtils.replaceBlank(t.getPhones());
					ps.add(cb.equal(root.get("phones"), mobile));
				}*/
				/*if (t.getAccount() != null && t.getAccount().getId() > 0L) {
					ps.add(cb.equal(root.get("account"), t.getAccount()));
				}*/
				if("1".equals(type)) {
					startTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);			
				} else if ("2".equals(type)) {
					startTime = LocalDateTime.now().plusDays(-7).withHour(0).withMinute(0).withSecond(0);
				} else if ("3".equals(type)) {
					startTime = LocalDateTime.now().plusMonths(-1).withHour(0).withMinute(0).withSecond(0);
				} else if ("4".equals(type)) {
					startTime = LocalDateTime.parse(param.getStartTime());
					endTime = LocalDateTime.parse(param.getEndTime());
				}
				if(startTime != null && endTime != null) {
					ps.add(cb.between(root.get("createTime"), startTime, endTime));
				}
				return CollectionUtils.isEmpty(ps) ? null : cb.and(ps.toArray(new Predicate[ps.size()]));
			}
		};
		Converter<AidRecord, AidRecordVo> converter = (e) -> {
			return new AidRecordVo(e);
		};
		Page<AidRecordVo> page = repository.findAll(spec, pageable).map(converter);
		//Page<AidRecord> page = repository.findAll(spec, pageable);
		return page;
	}
	
	@Override
	public AidRecordDetailVo getDetail(String id) {
		return repository.findDetailById(id);
	}

	@Override
	protected BaseRepository<AidRecord, Long> getRepository() {
		return repository;
	}

	private String parseToProcessText(String mainId, String processKqIds, String processAnswerIds) {
		List<Integer> kqIdList = Arrays.asList(processKqIds.split(",")).stream().map(Integer::parseInt).collect(toList());
		List<String> answerIdList = Arrays.asList(processAnswerIds.split(","));
		StringBuilder sb = new StringBuilder();
		
		List<KeyQ> keyqList = DataPool.get(KeyQ.class).stream().filter(e->e.getMainID().equals(mainId)).collect(toList());
		for (int i = 0; i < kqIdList.size(); i++) {
			int kqId = kqIdList.get(i);
			String answerId = answerIdList.get(i);
			
			String idx = i + "";
			Optional<KeyQ> optional = keyqList.stream().filter(e->e.getKqID()==kqId).filter(e->e.getAnswerId().equals(answerId)).findFirst();
			optional.ifPresent(e->{
				String questionText = e.getKqTitle();
				String answerText = e.getAnswer();
				sb.append(idx).append("、").append(questionText).append(":").append(answerText).append("<br>");
				//index++;
			});
		}
		return sb.toString();
	}

}
