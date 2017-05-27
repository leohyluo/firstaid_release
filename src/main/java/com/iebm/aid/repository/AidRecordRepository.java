package com.iebm.aid.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.AidRecord;
import com.iebm.aid.pojo.vo.AidRecordDetailVo;
import com.iebm.aid.pojo.vo.CallRecord;
import com.iebm.aid.pojo.vo.EmengencyRecord;
import com.iebm.aid.pojo.vo.PatientInfo;
import com.iebm.aid.utils.CollectionUtils;
import com.iebm.aid.utils.JpaHelper;
import com.iebm.aid.utils.StringUtils;

@Repository
public interface AidRecordRepository extends BaseRepository<AidRecord, Long> {

	List<AidRecord> findByCreateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
	
	@SuppressWarnings("unchecked")
	default AidRecordDetailVo findDetailById(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" b.user_name AS a_name, ");		//0
		sb.append(" b.gender AS a_gender, ");		//1
		sb.append(" b.birth AS a_birth, ");			//2
		sb.append(" b.national AS a_national, ");	//3
		sb.append(" b.marriage AS a_marriage, ");	//4
		sb.append(" b.past_ill AS a_past_ill, ");	//5
		sb.append(" b.history_drugAllergy AS a_history_drugAllergy, "); //6
		sb.append(" b.medical_cardNo AS a_medicalCardNo, ");  //7
		sb.append(" b.company AS a_company, ");  	//8
		sb.append(" b.job AS a_job, ");				//9
		sb.append(" b.mobile AS a_mobile, ");		//10
		sb.append(" b.address AS a_address, ");		//11
			
		sb.append(" b.cure_time AS b_cureTime, ");	//12
		sb.append(" b.main_symp AS b_mainSymptom, ");//13
		sb.append(" b.now_ill AS b_now_ill, ");		//14
		sb.append(" b.past_ill2 AS b_past_ill2, ");	//15
		sb.append(" b.body_check AS b_bodyCheck, ");//16
		sb.append(" b.assis_check AS b_assisCheck, ");//17
		sb.append(" b.diagnosis AS b_diagnosis, ");	//18
		sb.append(" b.principle AS b_principle, ");	//19
		sb.append(" b.signature AS b_signature, ");	//20
		
		sb.append(" b.main_symp AS c_mainSymptom, ");//21
		sb.append(" a.with_patient AS c_withPatient, ");//22
		sb.append(" a.`name` AS c_name, ");			//23
		sb.append(" a.age AS c_age, ");				//24
		sb.append(" a.gender AS c_gender, ");		//25
		sb.append(" a.has_aware AS c_hasAware, ");	//26
		sb.append(" a.has_breath AS c_hasBreath, ");//27	
		sb.append(" a.aid_address AS c_aidAddress, ");//28
		sb.append(" a.aid_mobile AS c_aidMobile, ");//29
		sb.append(" a.what_happen AS c_whatHappen, ");//30
		sb.append(" a.cure_process AS c_cureProcess ");//31
		sb.append(" FROM ");
		sb.append(" table_record a, ");
		sb.append(" table_aid_files b ");
		sb.append(" WHERE ");
		sb.append(" a.files_id = b.id ");
		sb.append(" AND a.id = :id ");
		
		String sql = sb.toString();
		List<Object[]> objList = JpaHelper.getEntityManager().createNamedQuery(sql).setParameter("id", id).getResultList();
		if(CollectionUtils.isNotEmpty(objList)) {
			Object[] arr = objList.get(0);
			PatientInfo patientInfo = new PatientInfo();
			patientInfo.setUserName(StringUtils.toString(arr[0]));
			patientInfo.setGender(StringUtils.toString(arr[1]));
			patientInfo.setBirth(StringUtils.toString(arr[2]));
			patientInfo.setNational(StringUtils.toString(arr[3]));
			patientInfo.setMarriage(StringUtils.toString(arr[4]));
			patientInfo.setPastIll(StringUtils.toString(arr[5]));
			patientInfo.setHistoryDrugAllergy(StringUtils.toString(arr[6]));
			patientInfo.setMedicalCardNo(StringUtils.toString(arr[7]));
			patientInfo.setCompany(StringUtils.toString(arr[8]));
			patientInfo.setJob(StringUtils.toString(arr[9]));
			patientInfo.setMobile(StringUtils.toString(arr[10]));
			patientInfo.setAddress(StringUtils.toString(arr[11]));
			
			EmengencyRecord emengencyRecord = new EmengencyRecord();
			emengencyRecord.setCureTime(StringUtils.toString(arr[12]));
			emengencyRecord.setMainSymp(StringUtils.toString(arr[13]));
			emengencyRecord.setNowIll(StringUtils.toString(arr[14]));
			emengencyRecord.setPastIll2(StringUtils.toString(arr[15]));
			emengencyRecord.setBodyCheck(StringUtils.toString(arr[16]));
			emengencyRecord.setAssisCheck(StringUtils.toString(arr[17]));
			emengencyRecord.setDiagnosis(StringUtils.toString(arr[18]));
			emengencyRecord.setPrinciple(StringUtils.toString(arr[19]));
			emengencyRecord.setSignature(StringUtils.toString(arr[20]));
			
			CallRecord callRecord = new CallRecord();
			callRecord.setMainSymptom(StringUtils.toString(arr[21]));
			callRecord.setStayWithPatient(StringUtils.toString(arr[22]));
			callRecord.setName(StringUtils.toString(arr[23]));
			callRecord.setAge(StringUtils.toString(arr[24]));
			callRecord.setGender(StringUtils.toString(arr[25]));
			callRecord.setHasAware(StringUtils.toString(arr[26]));
			callRecord.setHasBreath(StringUtils.toString(arr[27]));
			callRecord.setAidAddress(StringUtils.toString(arr[28]));
			callRecord.setAidMobile(StringUtils.toString(arr[29]));
			callRecord.setWhatHappen(StringUtils.toString(arr[30]));
			callRecord.setCureProcess(StringUtils.toString(arr[31]));
			
			AidRecordDetailVo vo = new AidRecordDetailVo(patientInfo, emengencyRecord, callRecord);
			return vo;
		}
		return null;
	}
}
