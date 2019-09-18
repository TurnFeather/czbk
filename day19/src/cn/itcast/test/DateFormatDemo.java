package cn.itcast.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class DateFormatDemo {
	@Test
	public void test1(){
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance();	//取日期。按照本地文化，默认样式输出
		String s = df.format(date);
		System.out.println(s);	//2017-3-29
		
		//样式有：DateFormat.FULL LONG MEDIUM SHORT
		df = DateFormat.getDateInstance(DateFormat.SHORT);		//去日期，按照本地文化，指定样式输出
		s = df.format(date);
		System.out.println(s);
		//FULL:2017年3月29日 星期三
		//LONG:2017年3月29日
		//MEDIUM:2017-3-29
		//SHORT:17-3-29
		
		Locale locale = Locale.US;
		df = DateFormat.getDateInstance(DateFormat.FULL,locale);		//去日期，按照本地文化，指定样式输出
		s = df.format(date);
		System.out.println(s);	//Wednesday, March 29, 2017
	}
}
