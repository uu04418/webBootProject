package com.bootproject.sklweb.common;

import java.util.Random;

import org.springframework.util.DigestUtils;


/**
 * @Description 数据解析 ID 生成策略
 * @author  uu04418
 * @date  2019年8月1日  下午3:55:01
 */
public class HandleData {


	/****
	**@Desctription 生成主键
	**@author  uu04418
	**@date  2019年8月1日  下午3:56:37
	**@return		
	*
	 */
	public static String generateKey() {
		long millis = System.currentTimeMillis();
		Random random = new Random();
		int end2 = random.nextInt(99);
		String str = millis + String.format("%02d", end2);
		String id = new String(str);
		return id;
	}
	
	/**
	**@Desctription MD5 加密器
	**@author  uu04418
	**@date  2019年8月1日  下午4:44:26
	**@param word
	**@return		
	*
	 */
	public static String digestMD5Word(String word) {
		String md5Password = DigestUtils.md5DigestAsHex(word.getBytes());
		return md5Password ;
	}
	
	

}
