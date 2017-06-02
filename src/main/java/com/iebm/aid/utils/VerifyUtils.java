package com.iebm.aid.utils;

import java.util.Arrays;
import java.util.List;

public class VerifyUtils {

	public static boolean isEmpty(List<String> params) {
		return params.stream().anyMatch(StringUtils::isEmpty);
	}
	
	public static boolean isEmpty(String... params) {
		List<String> paramList = Arrays.asList(params);
		return isEmpty(paramList);
	}
}
