package cn.itcast.filter.autologin;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5Util {
	public static String md5(String message){
		try{
			MessageDigest md = MessageDigest.getInstance("md5");
			byte b[] = md.digest(message.getBytes());
			return new BASE64Encoder().encode(b);				//������md5���ܺ��������base64����
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
