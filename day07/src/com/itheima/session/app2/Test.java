package com.itheima.session.app2;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class Test {
	public static void main(String[] args) throws Exception
	{
		String s = "zz";
		MessageDigest md = MessageDigest.getInstance("md5");
		byte b[] = md.digest(s.getBytes());
		BASE64Encoder base64 = new BASE64Encoder();
		String str = base64.encode(b);
		System.out.println(str);
	}
}
