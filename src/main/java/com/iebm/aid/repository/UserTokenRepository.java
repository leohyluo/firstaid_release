package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.UserToken;


@Repository
public interface UserTokenRepository extends BaseRepository<UserToken, Long> {

	List<UserToken> findByAccountAndHospitalCode(String account, String hospitalCode);
	
	List<UserToken> findByToken(String token);
}
