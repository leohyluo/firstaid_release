package com.iebm.aid.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.common.DataPool;
import com.iebm.aid.pojo.CacheKeyQ;
import com.iebm.aid.pojo.KeyQ;
import com.iebm.aid.pojo.Mpds;
import com.iebm.aid.repository.MpdsRepository;
import com.iebm.aid.service.CacheKeyQService;
import com.iebm.aid.service.MpdsService;
import com.iebm.aid.utils.CollectionUtils;
import com.iebm.aid.utils.StringUtils;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class MpdsServiceImpl extends AbstractService<Mpds, Long> implements MpdsService {
	
	@Resource
	private MpdsRepository repository;
	@Resource
	private CacheKeyQService cacheKeyQService;

	@Override
	public Mpds findMpdsGrade(CacheKeyQ cacheKeyq) {
		String mainId = cacheKeyq.getSympID();
		String processKqIds = cacheKeyq.getProcessKeyQIDs();
		String processAnswerIds = cacheKeyq.getProcessAnswerIDs();
		
		List<String> mpdsFlagList = new ArrayList<>();
		List<KeyQ> keyqList = DataPool.get(KeyQ.class).stream().filter(e->e.getMainID().equals(mainId)).collect(toList());
		List<String> processKqIdList = Arrays.asList(processKqIds.split(","));
		List<String> processAnswerIdList = Arrays.asList(processAnswerIds.split(","));
		for (int i = 0; i < processKqIdList.size(); i++) {
			String processKqId = processKqIdList.get(i);
			String processAnswerId = processAnswerIdList.get(i);
			Optional<String> optional = keyqList.stream().filter(e->e.getKqID()==Integer.parseInt(processKqId))
				.filter(e->e.getAnswerId().equals(processAnswerId)).map(e->e.getMpdsId()).findFirst();
			optional.ifPresent(e->{
				if(StringUtils.isNotEmpty(e)) {
					mpdsFlagList.add(e);
				}
			});
		}
		String mpdsFlag = mpdsFlagList.stream().sorted().findFirst().orElseGet(null);
		if(StringUtils.isNotEmpty(mpdsFlag)) {
			List<Mpds> mpdsList = repository.findByFlag(mpdsFlag);
			if(CollectionUtils.isNotEmpty(mpdsList)) {
				return mpdsList.get(0);
			}
		}
		return null;
	}

	@Override
	protected BaseRepository<Mpds, Long> getRepository() {
		return repository;
	}
}
