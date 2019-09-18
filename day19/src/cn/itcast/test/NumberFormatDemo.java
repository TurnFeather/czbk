package cn.itcast.test;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;

public class NumberFormatDemo {
	@Test
	public void test1(){
		int i = 100000000;
		NumberFormat nf = NumberFormat.getCurrencyInstance();//���ص�ǰĬ�����Ի����Ļ��Ҹ�ʽ��
		String s = nf.format(i);
		System.out.println(s);
		
		Locale locale = Locale.US;
		nf = NumberFormat.getCurrencyInstance(locale);//����ָ�����Ի����Ļ��Ҹ�ʽ��
		s = nf.format(i);
		System.out.println(s);
	}
}
