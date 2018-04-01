package com.hlx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class InfoUtil {

	//MD5加密数据
	public static String EncoderByMd5(String str){
		byte[] bytes;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		assert md != null;
		md.update(str.getBytes());
		bytes = md.digest();
		StringBuilder sb = new StringBuilder();
		for (byte aByte : bytes) {
			String s = Integer.toHexString(0xff & aByte);
			if (s.length() == 1) {
				sb.append("0").append(s);
			} else {
				sb.append(s);
			}
		}
		return sb.toString();
	}





}
