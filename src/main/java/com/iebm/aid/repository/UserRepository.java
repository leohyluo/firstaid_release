package com.iebm.aid.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.User;


@Repository
public interface UserRepository extends BaseRepository<User, Long> {

	List<User> findByUserNameAndHospitalCode(String userName, String hospitalCode);
	
	List<User> findByUserNameAndPassword(String userName, String password);
}
