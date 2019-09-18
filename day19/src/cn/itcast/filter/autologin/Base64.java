package cn.itcast.filter.autologin;

import java.io.IOException;

import org.junit.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
	@Test
	public void test(){
		BASE64Encoder be64 = new BASE64Encoder();
		String s = be64.encode("itheima14".getBytes());		//Encodes this String into a sequence of bytes using the platform's default charset, 
		String s1 = be64.encode("iamsorry".getBytes());
														//storing the result into a new byte array. 
		System.out.println("itheima14" + "=" + s);
		System.out.println("iamsorry" + "=" + s1);
	}
	
	@Test
	public void test2() throws IOException{
		BASE64Decoder be64 = new BASE64Decoder();
		String s = new String(be64.decodeBuffer("xOO6ww=="));
														
		System.out.println(s);
	}
}
