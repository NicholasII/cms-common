package com.sun.cms.common.utils;

import java.util.UUID;

public class UUIDUtil {
	
	/**
	 * 获取一个UUID
	 * @author dongqun
	 * 2018年2月23日下午2:27:04
	 * @return
	 */
	public static String generateUUID(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	
	/** 
	* 获得指定数目的UUID 
	* @param number int 需要获得的UUID数量 
	* @return String[] UUID数组 
	*/ 
	public static String[] generateBatchUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] retArray = new String[number];
		for (int i = 0; i < number; i++) {
			retArray[i] = generateUUID();
		}
		return retArray;
	}

}
