package com.hlx.util;

import java.util.Random;

/**
 * The util can create a random str that include the designated char str
 * @author hlx
 * @version 1.0 2017-?-?
 */
public class RandomUtil {
	
	private static final String  VALIDCHAR = "123456";
	
	public static String buildRandomStr(int len){
		StringBuilder str = new StringBuilder();
		Random random = new Random();
		for(int i=0;i<len;i++)
			str.append(VALIDCHAR.charAt(random.nextInt(VALIDCHAR.length())));
		return str.toString();
	}

}
