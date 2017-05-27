package com.iebm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@EnableCaching
@ServletComponentScan
@SpringBootApplication
@ImportResource(locations={"classpath:druid-bean.xml"})
/*@EntityScan(basePackages={"com.iebm.aid.pojo"})
@ComponentScan(basePackages={"com.iebm.aid.service"})
@EnableJpaRepositories(basePackages={"com.iebm.aid.repository"})*/
public class FirstAidApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstAidApplication.class, args);
	}
}
