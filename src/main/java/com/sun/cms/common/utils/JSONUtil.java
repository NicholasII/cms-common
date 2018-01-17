package com.sun.cms.common.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * fastjson工具包
 * @author dongqun
 * 2018年1月17日下午1:33:41
 */
public class JSONUtil {
	/**
	 * java对象转jsonobject
	 * @author dongqun
	 * 2018年1月17日下午1:56:06
	 * @param object
	 * @return
	 */
	public static JSONObject ObjectToJSONObject(Object object){
		String str_json = JSON.toJSONString(object);
		JSONObject jsonObject = JSON.parseObject(str_json);
		return jsonObject;				
	}
	/**
	 * list转jsonarray
	 * @author dongqun
	 * 2018年1月17日下午1:59:17
	 * @param list
	 * @return
	 */
	public static JSONArray ListToJSONArray(List list){
		String str_json = JSON.toJSONString(list);
		JSONArray jsonArray = JSON.parseArray(str_json);
		return jsonArray;
	}
	/**
	 * 字符串转jsonobject
	 * @author dongqun
	 * 2018年1月17日下午2:03:54
	 * @param text
	 * @return
	 */
	public static JSONObject StringToJSONObject(String text){
		return JSON.parseObject(text);
	}
	/**
	 * 字符串转jsonarray
	 * @author dongqun
	 * 2018年1月17日下午2:04:12
	 * @param text
	 * @return
	 */
	public static JSONArray StringToJSONArray(String text){
		return JSON.parseArray(text);
	}
	/**
	 * json转java对象
	 * @author dongqun
	 * 2018年1月17日下午2:08:54
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static Object JSONToObject(JSON json,Class clazz){
		return JSON.toJavaObject(json, clazz);
	}
	
}
