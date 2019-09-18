package cn.itcast.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class ResourceBundleDemo {
	@Test
	public void test1(){
		ResourceBundle rs = ResourceBundle.getBundle("cn.itcast.resources.msg");	//默认取本地的那个消息资源文件
		String str = rs.getString("hello");
		System.out.println(str);
	}
	@Test
	public void test2(){
		ResourceBundle rs = ResourceBundle.getBundle("cn.itcast.resources.msg",Locale.US);	
		String str = rs.getString("hello");
		System.out.println(str);
	}
}
