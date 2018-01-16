package com.sun.cms.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
/**
 * 文字编码
 * @author dongqun
 * 2018年1月16日下午1:47:10
 */
public class SecurityUtil {
	
	private static Logger logger = Logger.getLogger(SecurityUtil.class);
	/**
	 * MD5编码
	 * @author dongqun
	 * 2018年1月16日下午1:46:07
	 * @param text
	 * @return
	 */
	public static String getMD5(String text){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("获取MessageDigest对象错误");
		}
		if (md!=null) {
			md.update(text.getBytes(),0,text.length());
			BigInteger bi = new BigInteger(1, md.digest());
			return bi.toString(16);
		}else {
			return null;
		}	
	}
	
	/**
	 * SHA编码
	 * @author dongqun
	 * 2018年1月16日下午1:46:28
	 * @param text
	 * @return
	 */
	public static String getSHA(String text){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("获取MessageDigest对象错误");
		}
		if (md!=null) {
			md.update(text.getBytes(),0,text.length());
			BigInteger bi = new BigInteger(1, md.digest());
			return bi.toString(16);
		}else {
			return null;
		}	
	}
	
}
