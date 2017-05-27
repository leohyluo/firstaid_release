package com.iebm.aid.service;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.User;


public interface UserService extends BaseService<User, Long> {
	
	User find(String userName, String hospitalCode);
	
	User findByPassword(String username, String password);
}
