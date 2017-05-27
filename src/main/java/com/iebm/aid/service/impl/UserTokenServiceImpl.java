package com.iebm.aid.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.iebm.aid.common.AbstractService;
import com.iebm.aid.common.BaseRepository;
import com.iebm.aid.pojo.User;
import com.iebm.aid.pojo.UserToken;
import com.iebm.aid.pojo.vo.TokenVo;
import com.iebm.aid.repository.UserTokenRepository;
import com.iebm.aid.service.UserTokenService;
import com.iebm.aid.utils.Encrypt;
import com.iebm.aid.utils.RandomUtils;

@Service
public class UserTokenServiceImpl extends AbstractService<UserToken, Long> implements UserTokenService {

	@Resource
	private UserTokenRepository repository;
		
	@Override
	public UserToken create(User user) {
		List<UserToken> list = repository.findByAccountAndHospitalCode(user.getUserName(), user.getHospitalCode());
		UserToken userToken = list.stream().findFirst().orElseGet(UserToken::new);
		
		String token = getToken(user);
		userToken.setAccount(user.getUserName());
		userToken.setToken(token);
		userToken.setHospitalCode(user.getHospitalCode());
		userToken.setLastupdTime(LocalDateTime.now());
		repository.save(userToken);
		return userToken;
	}
	
	@Override
	public UserToken findByToken(String token) {
		List<UserToken> tokenList = repository.findByToken(token);
		if(CollectionUtils.isEmpty(tokenList)) {
			return null;
		} else {
			return tokenList.get(0);
		}
	}
	
	@Override
	protected BaseRepository<UserToken, Long> getRepository() {
		return repository;
	}
	
	private String getToken(User user) {
		//token=用户id(5位,不足的在前面补0)+账号+8位随机数+医院编码(后8位),然后用MD5进行加密
				
		TokenVo vo = new TokenVo();
		vo.setUserId(String.valueOf(user.getId()));
		vo.setUserName(user.getUserName());
		vo.setRandomNo(RandomUtils.generateString(8));
		//vo.setHospitalCode(user.getHospitalCode());
		String token = Encrypt.getToken(vo); 
		
		return token;
	}

	
}
