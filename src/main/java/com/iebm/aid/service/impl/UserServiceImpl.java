package com.iebm.aid.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.User;
import com.iebm.aid.repository.UserRepository;
import com.iebm.aid.service.UserService;

@Service
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {

	@Resource
	private UserRepository repository;	
	
	@Override
	public User find(String userName, String hospitalCode) {
		List<User> userList = repository.findByUserNameAndHospitalCode(userName, hospitalCode);
		User user = null;
		if(!CollectionUtils.isEmpty(userList)) {
			user = userList.get(0);
		}
		return user;
	}	
	
	@Override
	public User findByPassword(String username, String password) {
		List<User> userList = repository.findByUserNameAndPassword(username, password);
		User user = null;
		if(!CollectionUtils.isEmpty(userList)) {
			user = userList.get(0);
		}
		return user;
	}

	@Override
	public List<User> findByUserName(String username) {
		List<User> userList = repository.findByUserName(username);
		return userList;
	}
	
	@Override
	protected BaseRepository<User, Long> getRepository() {
		return repository;
	}



}
