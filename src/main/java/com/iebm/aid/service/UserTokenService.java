package com.iebm.aid.service;

import com.iebm.aid.common.BaseService;
import com.iebm.aid.pojo.User;
import com.iebm.aid.pojo.UserToken;


public interface UserTokenService extends BaseService<UserToken, Long> {

	UserToken create(User user);
	
	UserToken findByToken(String token);
}
