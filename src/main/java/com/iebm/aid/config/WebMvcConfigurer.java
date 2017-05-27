package com.iebm.aid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.iebm.aid.framework.SpringContextHolder;
import com.iebm.aid.interceptor.AuthInterceptor;


@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/app/**")
			.excludePathPatterns("/app/user/login");
		super.addInterceptors(registry);
	}
	
	@Bean
	public SpringContextHolder springContextHolder() {
		return new SpringContextHolder();
	}
}
