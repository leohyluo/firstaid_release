package com.iebm.aid.listener;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iebm.aid.common.DataPool;
import com.iebm.aid.pojo.KeyQ;
import com.iebm.aid.pojo.KeyQUse;
import com.iebm.aid.pojo.KqplanLink;
import com.iebm.aid.repository.KeyQRepository;
import com.iebm.aid.repository.KeyQUseRepository;
import com.iebm.aid.repository.KqplanLinkRepository;


@WebListener
public class WebContextListener implements ServletContextListener {
	
	@Resource
	private KeyQRepository keyQRepository;
	@Resource
	private KeyQUseRepository keyQUseRepository;
	@Resource
	private KqplanLinkRepository kqplanLinkRepository; 
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("webContextListener contextInitialized starting...");
		DataPool.init();
		loadKeyQ();
		loadKeyqUse();
		loadKqplanLink();
		logger.info("webContextListener contextInitialized completed");
	}
	
	private void loadKeyQ() {
		List<KeyQ> keyqList = keyQRepository.findAllAndDefaultOrder();
		DataPool.put(keyqList);
	}

	private void loadKeyqUse() {
		List<KeyQUse> keyquseList = keyQUseRepository.findAll();
		DataPool.put(keyquseList);
	}
	
	private void loadKqplanLink() {
		List<KqplanLink> kqplanLinkList = kqplanLinkRepository.findAll();
		DataPool.put(kqplanLinkList);
	}
}
