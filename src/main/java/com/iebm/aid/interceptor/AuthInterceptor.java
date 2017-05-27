package com.iebm.aid.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iebm.aid.framework.SpringContextHolder;
import com.iebm.aid.pojo.UserToken;
import com.iebm.aid.pojo.vo.TokenVo;
import com.iebm.aid.service.UserTokenService;
import com.iebm.aid.service.impl.UserTokenServiceImpl;
import com.iebm.aid.utils.Encrypt;
import com.iebm.aid.web.ResponseMessage;
import com.iebm.aid.web.ResponseStatus;
import com.iebm.aid.web.WebUtils;

public class AuthInterceptor implements HandlerInterceptor {
		
	private UserTokenService userTokenService; 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String token = request.getHeader("token");
		
		System.out.println("***"+token);
		ResponseMessage responseMessage = null;
		
		boolean result = true;
		try {
			userTokenService = SpringContextHolder.getBean(UserTokenServiceImpl.class);
			UserToken userToken = userTokenService.findByToken(token);
			if(userToken == null) {
				responseMessage = WebUtils.buildResponseMessage(ResponseStatus.ACCESS_TOKEN_NOT_EXISTS);
				result = false;
			} else {
				TokenVo tokenVo = Encrypt.toTokenVo(token);
				request.setAttribute("tokenVo", tokenVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseMessage = WebUtils.buildResponseMessage(ResponseStatus.ACCESS_TOKEN_INCORRECT);
			result = false;
		}
		if(result == false) {
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			writer.write(responseMessage.toJsonString());
		}
		return result;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
