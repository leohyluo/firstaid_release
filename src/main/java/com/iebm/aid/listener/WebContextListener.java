package com.iebm.aid.listener;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.iebm.aid.common.DataPool;
import com.iebm.aid.pojo.KeyQ;
import com.iebm.aid.pojo.KeyQUse;
import com.iebm.aid.pojo.KqplanLink;
import com.iebm.aid.pojo.Plan;
import com.iebm.aid.repository.KeyQRepository;
import com.iebm.aid.repository.KeyQUseRepository;
import com.iebm.aid.repository.KqplanLinkRepository;
import com.iebm.aid.repository.PlanRepository;
import com.iebm.aid.utils.JpaHelper;
import com.iebm.aid.utils.NetUtils;
import com.iebm.aid.utils.StringUtils;


@WebListener
public class WebContextListener implements ServletContextListener {
	
	@Resource
	private KeyQRepository keyQRepository;
	@Resource
	private KeyQUseRepository keyQUseRepository;
	@Resource
	private KqplanLinkRepository kqplanLinkRepository;
	@Resource
	private PlanRepository planRepository;
	@Resource
	private EntityManager entityManager;
	@Value("${local.hostname.mac}")
	private String localMac;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("webContextListener contextInitialized starting...");
		installCheck();
		initEntityManager();
		DataPool.init();
		loadKeyQ();
		loadKeyqUse();
		loadKqplanLink();
		loadPlan();
		logger.info("webContextListener contextInitialized completed");
	}
	
	private void installCheck() {
		try {
			//String localMac = "PC-20160606PUVI/B0-D5-9D-7E-C6-01A";
			if(StringUtils.isEmpty(localMac)) {
				return;
			}
			List<String> macList = NetUtils.getLocalMac();
			boolean match = macList.stream().anyMatch(e->e.equalsIgnoreCase(localMac));
			if(match) {
				logger.info("install check success, application starting...");				
			} else {
				logger.info("install check failed, application stop.");
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initEntityManager() {
		JpaHelper.setEntityManager(entityManager);
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
	
	private void loadPlan() {
		List<Plan> planList = planRepository.findAll();
		DataPool.put(planList);
	}
}
