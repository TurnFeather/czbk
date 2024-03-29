package com.itheima.session.app2;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5Util {
	public static String encode(String message)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("md5");
			byte [] b = md.digest(message.getBytes());
			return new BASE64Encoder().encode(b);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String [] args)
	{
		System.out.println(encode("abcdefg"));
	}
}
