package cn.itcast.test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class MessageFormatDemo {
	@Test
	public void test1(){
		//占位符对应参数数组中的元素
		String pattern = "At {0} on {0} a hurricance destroyed {1} houses and caused {2} of damage";	//模式字符串
		Object params[] = new Object[]{new Date(),99,1000000};
		//MessageFormat 获取一组对象，格式化这些对象，然后将格式化后的字符串插入到模式中的适当位置。
		String s  = MessageFormat.format(pattern, params);
		System.out.println(s);
		//占位符有3种书写方式
		/* 
		 	{argumentIndex}: 0-9 之间的数字，表示要格式化对象数据在参数数组中的索引号
			{argumentIndex,formatType}: 参数的格式化类型
			{argumentIndex,formatType,FormatStyle}: 格式化的样式，它的值必须是与格式化类型相匹配的合法模式、或表示合法模式的字符串。
		 */
		pattern = "At {0,time,long} on {0,date,medium} a hurricance destroyed {1} houses and caused {2,number,currency} of damage";
		s  = MessageFormat.format(pattern, params);
		System.out.println(s);
		MessageFormat mf = new MessageFormat(pattern,Locale.US);
		s = mf.format(params);
		System.out.println(s);
	}
}
