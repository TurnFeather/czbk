package cn.itcast.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class DateFormatDemo {
	@Test
	public void test1(){
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance();	//ȡ���ڡ����ձ����Ļ���Ĭ����ʽ���
		String s = df.format(date);
		System.out.println(s);	//2017-3-29
		
		//��ʽ�У�DateFormat.FULL LONG MEDIUM SHORT
		df = DateFormat.getDateInstance(DateFormat.SHORT);		//ȥ���ڣ����ձ����Ļ���ָ����ʽ���
		s = df.format(date);
		System.out.println(s);
		//FULL:2017��3��29�� ������
		//LONG:2017��3��29��
		//MEDIUM:2017-3-29
		//SHORT:17-3-29
		
		Locale locale = Locale.US;
		df = DateFormat.getDateInstance(DateFormat.FULL,locale);		//ȥ���ڣ����ձ����Ļ���ָ����ʽ���
		s = df.format(date);
		System.out.println(s);	//Wednesday, March 29, 2017
	}
}
