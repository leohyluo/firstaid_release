package com.iebm.aid.utils;

import javax.persistence.EntityManager;

public class JpaHelper {

	private JpaHelper() {}
	
	private static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void setEntityManager(EntityManager input) {
		if(entityManager == null)
			entityManager = input;
	}
	
	
}
