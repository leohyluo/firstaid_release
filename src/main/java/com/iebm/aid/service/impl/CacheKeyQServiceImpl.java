package com.iebm.aid.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.common.DataPool;
import com.iebm.aid.controller.req.BasicInfoReq;
import com.iebm.aid.pojo.CacheKeyQ;
import com.iebm.aid.pojo.KeyQ;
import com.iebm.aid.pojo.KeyQUse;
import com.iebm.aid.pojo.vo.KeyQVo;
import com.iebm.aid.repository.CacheKeyQRepository;
import com.iebm.aid.service.CacheKeyQService;
import com.iebm.aid.service.KeyQService;
import com.iebm.aid.service.KeyQUseService;
import com.iebm.aid.utils.CollectionUtils;
import com.iebm.aid.utils.StringUtils;
import static java.util.stream.Collectors.toList;

@Service
public class CacheKeyQServiceImpl extends AbstractService<CacheKeyQ, Long> implements CacheKeyQService {

	@Resource
	private CacheKeyQRepository repository;
	@Resource
	private KeyQService keyQService;
	@Resource
	private KeyQUseService keyQUseService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<KeyQVo> getFirstKeyQ(BasicInfoReq basicInfo, String serverId) {
		String mainId = basicInfo.getMainSymptomId();
		//List<KeyQ> keyQList = keyQService.findByMainSymptomId(mainId);
		List<KeyQ> keyQList = DataPool.get(KeyQ.class).stream().filter(e->e.getMainID().equals(mainId)).collect(toList());
		List<KeyQ> filterKeyQList = parsekeyQData(basicInfo, keyQList);
		
		if(CollectionUtils.isEmpty(filterKeyQList)) {
			logger.warn("not found question by basicInfo", basicInfo);
			return null;
		}
		String kqids = saveCacheKeyQ(basicInfo, filterKeyQList, serverId);
		String firstKqId = kqids.split(",")[0];
		List<KeyQVo> firstQues = filterKeyQList.stream().filter(e->firstKqId.equals(e.getKqID().toString()))
				.map(KeyQVo::new).collect(toList());
		return firstQues;
	}

	@Override
	public CacheKeyQ findByServerId(String serverId) {
		CacheKeyQ cacheKeyQ = null;
		List<CacheKeyQ> list = repository.findByServerId(serverId);
		if(CollectionUtils.isNotEmpty(list)) {
			cacheKeyQ = list.get(0);
		}
		return cacheKeyQ;
	}

	@Override
	protected BaseRepository<CacheKeyQ, Long> getRepository() {
		return repository;
	}
	
	/**
	 * 过滤问题列表
	 * @param keyQDataList
	 * @return
	 */
	private List<KeyQ> parsekeyQData(BasicInfoReq basicInfo, List<KeyQ> keyQDataList) {
		final ArrayList<Integer> includKeyQIdList = new ArrayList<Integer>(); //
 		final ArrayList<Integer> excludeKeyQIdList = new ArrayList<Integer>(); //不应该出现的问题id列表
 		String mainSymptomId = basicInfo.getMainSymptomId();
		//List<KeyQUse> keyQUseBeanList = keyQUseService.findByMainSymptomId(mainSymptomId);
 		List<KeyQUse> keyQUseBeanList = DataPool.get(KeyQUse.class).stream()
 				.filter(e->e.getMainID().equals(mainSymptomId)).collect(toList());
		
 		KeyQUse tempKeyQUseBean;
 		for(int i=0,num=keyQUseBeanList.size(); i<num; ++i) {
 			tempKeyQUseBean = keyQUseBeanList.get(i); 					
 			if(!calculateMatch(basicInfo, tempKeyQUseBean)) {
 				excludeKeyQIdList.add(Integer.parseInt(tempKeyQUseBean.getKqID()));
 			}
 			else {
 				includKeyQIdList.add(Integer.parseInt(tempKeyQUseBean.getKqID()));
 			}
 		}
 		
 		final ArrayList<KeyQ> tempKeyQBeanList = new ArrayList<KeyQ>(keyQDataList.size());
 		for(int i=0,num=keyQDataList.size(); i<num; ++i) {
 			int id = keyQDataList.get(i).getKqID();
 			if(!excludeKeyQIdList.contains(id) || includKeyQIdList.contains(id)) {
 				tempKeyQBeanList.add(keyQDataList.get(i));
 			}
 		}
		
		return tempKeyQBeanList; 		
	}
	
	private boolean calculateMatch(BasicInfoReq basicInfo, KeyQUse keyqUse) {
 		if(basicInfo == null || keyqUse == null) {
 			return false;
 		}
 		
 		//int[] sourceData = parseToArray(basicInfo);
 		String basicInfoStr = basicInfo.toCommonString();
 		List<Integer> list = Arrays.asList(basicInfoStr.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
 		Object[] sourceData = list.toArray();
 		
 		int[] targetData = parseToArray(keyqUse);
 		
 		final int num = Math.min(sourceData.length, targetData.length);
 		for(int i=0; i<num; ++i) {
 			if(targetData[i]<= 0) {
 				continue;
 			}
 			Integer itemSourceData = Integer.parseInt(sourceData[i].toString());
 			if(itemSourceData != targetData[i]) {
 				return false;
 			}
 		}
 		
 		return true;
 	}
	
	/*private int[] parseToArray(BasicInfoReq basicInfo) {
		int[] sourceData = new int[7];
		String callType = basicInfo.getCallType();
		String stayWithPatient = basicInfo.getStayWithPatient();
		String age = basicInfo.getAge();
		String gender = basicInfo.getGender();
		String hasAware = basicInfo.getHasAware();
		String hasBreath = basicInfo.getHasBreath();
		String hasSpecDis = basicInfo.getSpecDisId();
		
 		if(StringUtils.isEmpty(callType)) {
 			sourceData[0] = 0;
 		} else {
 			sourceData[0] = Integer.parseInt(callType);
 		}
 		if(StringUtils.isEmpty(stayWithPatient)) {
 			sourceData[1] = 0;
 		} else {
 			sourceData[1] = Integer.parseInt(stayWithPatient);
 		}
 		if(StringUtils.isEmpty(age)) {
 			sourceData[2] = 0;
 		} else {
 			sourceData[2] = Integer.parseInt(age);
 		}
 		if(StringUtils.isEmpty(gender)) {
 			sourceData[3] = 0;
 		} else {
 			sourceData[3] = Integer.parseInt(gender);
 		}
 		if(StringUtils.isEmpty(hasAware)) {
 			sourceData[4] = 0;
 		} else {
 			sourceData[4] = Integer.parseInt(hasAware);
 		}
 		if(StringUtils.isEmpty(hasBreath)) {
 			sourceData[5] = 0;
 		} else {
 			sourceData[5] = Integer.parseInt(hasBreath);
 		}
 		if(StringUtils.isEmpty(hasSpecDis)) {
 			sourceData[6] = 0;
 		} else {
 			sourceData[6] = Integer.parseInt(hasSpecDis);
 		}
 		return sourceData;
	}*/
	
	private int[] parseToArray(KeyQUse keyqUse) {
		int[] sourceData = new int[7];
		String callType = keyqUse.getCallType();
		String stayWithPatient = keyqUse.getWithPatient();
		String age = keyqUse.getAge();
		String gender = keyqUse.getGender();
		String hasAware = keyqUse.getHasAware();
		String hasBreath = keyqUse.getHasBreath();
		String hasSpecDis = keyqUse.getDisID();
		
 		if(StringUtils.isEmpty(callType)) {
 			sourceData[0] = 0;
 		} else {
 			sourceData[0] = Integer.parseInt(callType);
 		}
 		if(StringUtils.isEmpty(stayWithPatient)) {
 			sourceData[1] = 0;
 		} else {
 			sourceData[1] = Integer.parseInt(stayWithPatient);
 		}
 		if(StringUtils.isEmpty(age)) {
 			sourceData[2] = 0;
 		} else {
 			sourceData[2] = Integer.parseInt(age);
 		}
 		if(StringUtils.isEmpty(gender)) {
 			sourceData[3] = 0;
 		} else {
 			sourceData[3] = Integer.parseInt(gender);
 		}
 		if(StringUtils.isEmpty(hasAware)) {
 			sourceData[4] = 0;
 		} else {
 			sourceData[4] = Integer.parseInt(hasAware);
 		}
 		if(StringUtils.isEmpty(hasBreath)) {
 			sourceData[5] = 0;
 		} else {
 			sourceData[5] = Integer.parseInt(hasBreath);
 		}
 		if(StringUtils.isEmpty(hasSpecDis)) {
 			sourceData[6] = 0;
 		} else {
 			sourceData[6] = Integer.parseInt(hasSpecDis);
 		}
 		return sourceData;
	}
	
	private String saveCacheKeyQ(BasicInfoReq basicInfo, List<KeyQ> allKeyQList, String randomStr) {
		/*int[] arr = parseToArray(basicInfo);
		final StringBuffer baseInfoBuffer = new StringBuffer();
		for(int i=0; i<arr.length; ++i) {
			baseInfoBuffer.append(arr[i]);
			if(i<arr.length-1) {
				baseInfoBuffer.append(",");
			}
		}
		String baseInfoStr = baseInfoBuffer.toString();*/
		Set<Integer> kqidSet = allKeyQList.stream().map(KeyQ::getKqID).collect(Collectors.toSet());
		List<Integer> kqids = new ArrayList<>();
		kqids.addAll(kqidSet);
		kqids.sort((e1,e2)->e1.compareTo(e2));
		StringJoiner sj = new StringJoiner(",");
		kqids.forEach(e->{
			sj.add(String.valueOf(e));
		});
		String allKeyQIds = sj.toString();
		
		CacheKeyQ ckq = new CacheKeyQ();
		ckq.setUserID(null);
		ckq.setServerId(randomStr);
		ckq.setSympID(basicInfo.getMainSymptomId());
		ckq.setBaseInfos(basicInfo.toCommonString());
		ckq.setAllKeyQIDs(allKeyQIds);
		ckq.setAllKeyQTypes(null);
		ckq.setAllKQForwardIDs(null);
		ckq.setProcessKeyQIDs(null);
		ckq.setProcessAnswerIDs(null);
		ckq.setDateTime(null);
		save(ckq);
		return allKeyQIds;
	}
	
	/*private void saveCacheKeyQ(BasicInfoReq basicInfo, List<KeyQ> allKeyQList) {
		int[] arr = parseToArray(basicInfo);
		final StringBuffer baseInfoBuffer = new StringBuffer();
		for(int i=0; i<arr.length; ++i) {
			baseInfoBuffer.append(arr[i]);
			if(i<arr.length-1) {
				baseInfoBuffer.append("/");
			}
		}
		String baseInfoStr = baseInfoBuffer.toString();
		final String[] keyQIDs$Types = this.formatKeyQID$TypeInfo(allKeyQList);
		CacheKeyQ ckq = new CacheKeyQ();
		ckq.setUserID(null);
		ckq.setServerId(null);
		ckq.setSympID(basicInfo.getMainSymptomId());
		ckq.setBaseInfos(baseInfoStr);
		ckq.setAllKeyQIDs(keyQIDs$Types[0]);
		ckq.setAllKeyQTypes(keyQIDs$Types[1]);
		ckq.setAllKQForwardIDs(keyQIDs$Types[2]);
		ckq.setProcessKeyQIDs(null);
		ckq.setProcessAnswerIDs(null);
		ckq.setDateTime(null);
		save(ckq);
	}*/
	
	/*private String[] formatKeyQID$TypeInfo(List<KeyQ> keyQDataList) {
		logger.info("FAidUtil formatKeyQID$TypeInfo() " + keyQDataList);
		
		final StringBuffer keyQIDsBuffer = new StringBuffer();
		final StringBuffer keyqTypesBuffer = new StringBuffer();
		final StringBuffer kqForwardIDsBuffer = new StringBuffer();
		
		KeyQ keyQBean;
		for(int i=0,num=keyQDataList.size(); i<num; ++i) {
			keyQBean = keyQDataList.get(i);
			keyQIDsBuffer.append(keyQBean.getKqID());
			keyqTypesBuffer.append(keyQBean.getForwardFlag());
			kqForwardIDsBuffer.append(keyQBean.getForwardId());
			
			if(i < num-1) {
				keyQIDsBuffer.append("/");
				keyqTypesBuffer.append("/");
				kqForwardIDsBuffer.append("/");
			}
		}
		logger.info("FAidUtil formatKeyQID$TypeInfo() " + keyQIDsBuffer + "," + keyqTypesBuffer.toString() + "," + kqForwardIDsBuffer.toString());
		
		return new String[]{keyQIDsBuffer.toString(), keyqTypesBuffer.toString(), kqForwardIDsBuffer.toString()};
	}*/
}
