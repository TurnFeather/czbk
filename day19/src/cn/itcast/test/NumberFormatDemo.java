package cn.itcast.test;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;

public class NumberFormatDemo {
	@Test
	public void test1(){
		int i = 100000000;
		NumberFormat nf = NumberFormat.getCurrencyInstance();//返回当前默认语言环境的货币格式。
		String s = nf.format(i);
		System.out.println(s);
		
		Locale locale = Locale.US;
		nf = NumberFormat.getCurrencyInstance(locale);//返回指定语言环境的货币格式。
		s = nf.format(i);
		System.out.println(s);
	}
}
