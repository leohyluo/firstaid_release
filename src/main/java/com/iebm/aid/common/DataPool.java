package com.iebm.aid.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.iebm.aid.utils.CollectionUtils;

public class DataPool {
	
	private static DataPool instance;
	//对象集合数据缓存池
	private static Map<Class<?>, List<?>> map;
	//单个对象数据缓存池
	private static Map<String, Object> objectMap;

	private DataPool() {
		map = new ConcurrentHashMap<>();
		objectMap = new ConcurrentHashMap<>();
	}
	
	public static void init() {
		if(instance == null) {
			instance = new DataPool();
		}
	}
	
	public static <T> void put(List<T> list) {
		Class<?> key = list.stream().findFirst().get().getClass();
		map.put(key, list);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> get(Class<T> clazz) {
		List<?> list = map.get(clazz);
		if(CollectionUtils.isEmpty(list)) {
			return new ArrayList<>();
		}
		List<T> resultList = (List<T>) list;
		return resultList;
	}
	
	public static <T> void put(String key, T t) {
		objectMap.put(key, t);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T take(String key, Class<T> clazz) {
		T t = null;
		if(objectMap.containsKey(key)) {
			Object obj = objectMap.get(key);
			objectMap.remove(key);
			t = (T) obj;
		}		
		return t;
	}
}
