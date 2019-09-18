package cn.itcast.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class ResourceBundleDemo {
	@Test
	public void test1(){
		ResourceBundle rs = ResourceBundle.getBundle("cn.itcast.resources.msg");	//Ĭ��ȡ���ص��Ǹ���Ϣ��Դ�ļ�
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
