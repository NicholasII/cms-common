package com.sun.cms.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Captcha {
	
	private int width;
	
	private int height;
	
	private int num;
	
	private static Captcha captcha;
	
	public static Captcha getInstance(){
		if (captcha==null) {
			captcha = new Captcha();
		}
		return captcha;
	}
	private Captcha(){
		height = 50;
		width = 200;
		num = 4;
	}
	
	public void set(int width,int height,int num){
		this.height=height;
		this.width=width;
		this.num=num;
	}
	
	private static Random random = new Random();
	/**
	 * 获取验证码
	 * @author dongqun
	 * 2018年1月16日下午4:03:46
	 * @return
	 */
	public String generateCheckCode(){
		String code = "0123456789";		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < num; i++) {
			builder.append(code.charAt(random.nextInt(code.length())));
		}
		return builder.toString();	
	}
	/**
	 * 获取验证码图片
	 * @author dongqun
	 * 2018年1月16日下午4:19:38
	 * @param code
	 * @return
	 */
	public BufferedImage generateCheckImage(String code){
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D graphic =  bi.createGraphics();
		graphic.setColor(Color.white);
		graphic.fillRect(0, 0, width, height);
		graphic.setColor(Color.GRAY);
		graphic.drawRect(0, 0, width-1, height-1);
		Font font = new Font("宋体", Font.BOLD+Font.ITALIC, (int) (height*0.8));
		graphic.setFont(font);
		for (int i = 0; i < num; i++) {
			graphic.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			graphic.drawString(String.valueOf(code.charAt(i)),4+(width/num)*i , (int) (height*0.8));
		}
		for (int i = 0; i < height+width; i++) {
			graphic.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			graphic.drawOval(random.nextInt(255), random.nextInt(255), 1, 1);
		}
		for (int i = 0; i < num; i++) {
			graphic.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			graphic.drawLine(0, random.nextInt(height), width, random.nextInt(height));
		}
		return bi;
	}
}
