package com.iebm.aid.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {
	
	private static Map<String, String> map;
	
	/*static {
		try {
			map = new HashMap<>();
			Properties prop = new Properties();
			// 读取属性文件a.properties
			String filePath = PropertiesUtils.class.getResource("/fjzl.properties").getPath();
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			prop.load(in); /// 加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				map.put(key, prop.getProperty(key));
			}
			in.close();

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}*/
	
	public static String read(String key) {
		return map.get(key);
	}
	
	
}
