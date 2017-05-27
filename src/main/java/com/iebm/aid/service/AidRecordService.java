package com.iebm.aid.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.controller.req.SearchAidFilesParam;
import com.iebm.aid.pojo.AidFiles;
import com.iebm.aid.pojo.AidRecord;
import com.iebm.aid.pojo.vo.AidRecordDetailVo;
import com.iebm.aid.pojo.vo.AidRecordVo;
import com.iebm.aid.pojo.vo.PlanVo;

public interface AidRecordService extends BaseService<AidRecord, Long> {

	/**
	 * 保存急救档案
	 * @param aidFiles
	 */
	Long saveAidFiles(AidFiles aidFiles);
	
	/**
	 * 保存诊断记录
	 * @param aidRecord
	 */
	void saveAidRecord(String serverId, List<PlanVo> planvoList);
	
	/**
	 * 搜索急救记录
	 * @param param
	 * @return
	 */
	List<AidRecordVo> search(SearchAidFilesParam param);
	
	/**
	 * 查询急救记录详情
	 * @param id
	 * @return
	 */
	AidRecordDetailVo getDetail(String id);
	
	Page<AidRecordVo> findByPage(SearchAidFilesParam param);
}
