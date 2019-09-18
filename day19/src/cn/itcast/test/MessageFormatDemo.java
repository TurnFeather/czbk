package cn.itcast.test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class MessageFormatDemo {
	@Test
	public void test1(){
		//ռλ����Ӧ���������е�Ԫ��
		String pattern = "At {0} on {0} a hurricance destroyed {1} houses and caused {2} of damage";	//ģʽ�ַ���
		Object params[] = new Object[]{new Date(),99,1000000};
		//MessageFormat ��ȡһ����󣬸�ʽ����Щ����Ȼ�󽫸�ʽ������ַ������뵽ģʽ�е��ʵ�λ�á�
		String s  = MessageFormat.format(pattern, params);
		System.out.println(s);
		//ռλ����3����д��ʽ
		/* 
		 	{argumentIndex}: 0-9 ֮������֣���ʾҪ��ʽ�����������ڲ��������е�������
			{argumentIndex,formatType}: �����ĸ�ʽ������
			{argumentIndex,formatType,FormatStyle}: ��ʽ������ʽ������ֵ���������ʽ��������ƥ��ĺϷ�ģʽ�����ʾ�Ϸ�ģʽ���ַ�����
		 */
		pattern = "At {0,time,long} on {0,date,medium} a hurricance destroyed {1} houses and caused {2,number,currency} of damage";
		s  = MessageFormat.format(pattern, params);
		System.out.println(s);
		MessageFormat mf = new MessageFormat(pattern,Locale.US);
		s = mf.format(params);
		System.out.println(s);
	}
}
