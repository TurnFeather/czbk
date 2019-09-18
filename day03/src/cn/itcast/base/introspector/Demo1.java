package cn.itcast.base.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;
//内省：操作属性的（类中的getter和setter方法）
public class Demo1 {
	@Test
	public void test1() throws Exception
	{
		//得到Student类中的属性,被封装到BeanInfo中
		BeanInfo info =  Introspector.getBeanInfo(Student.class);
		//得到类中所有的属性描述器
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		System.out.println(pds.length);
		for (PropertyDescriptor pd : pds)
		{
			System.out.println(pd.getName());
		}
	}
	@Test
	public void test2() throws Exception
	{
		Student s = new Student();
		PropertyDescriptor pd = new PropertyDescriptor("name",Student.class);
		Method m = pd.getReadMethod();
		String value = (String)m.invoke(s, null);
		System.out.println(value);
		//改变name的值
		Method m1 = pd.getWriteMethod();
		m1.invoke(s, "张三");
		System.out.println(s.getName());
	}
	//利用BeanUtils框架操作属性
	@Test
	public void test3() throws Exception
	{
		Student s = new Student();
		//为什么要返回字符串:用户的所有输入都是字符串
		String str = BeanUtils.getProperty(s, "name");		//这儿就是实际上调用getName（）方法
		System.out.println(str);
		//设置值
		BeanUtils.setProperty(s, "name", "张继科");
		System.out.println(s.getName());
	}
	@Test//BeanUtils可以进行类型的自动转换，但仅限基本的东西：本来需要int型，给个字符串，ok
	public void test4() throws Exception
	{
		Student s = new Student();
		//为什么要返回字符串:用户的所有输入都是字符串
		String str = BeanUtils.getProperty(s, "age");		//这儿就是实际上调用getName（）方法
		System.out.println(str);
		//设置值
		BeanUtils.setProperty(s, "age", "19");
		System.out.println(s.getAge());
	}
	//非基本类型的属性的设置
	//用户的输入都是String
	//String <------>其它类型之间的转换
	//用户看到的结果都是字符串
	@Test
	public void test5() throws Exception
	{
		Student s = new Student();
		//给BeanUtils注册类型转换器:自定义转换器
		ConvertUtils.register(new Converter(){
			//type:是目标类型
			//value：当前传入的值
			public Object convert(Class type, Object value) {
				/*
				if (type.equals(Date.class)){
					//字符串转换为Date
				}else
				{
					//Date转换为字符串
				}*/
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	//日期/时间格式化子类（如 SimpleDateFormat）允许进行格式化（也就是日期 -> 文本）、
																	//解析（文本-> 日期）和标准化。将日期表示为 Date 对象，或者表示为从 GMT（格林尼治标准时间）
																	//1970 年 1 月 1 日 00:00:00 这一刻开始的毫秒数。
				if (value instanceof String)
				{
					//字符串转Date
					String v = (String)value;
					try {
						Date d = df.parse(v);
						return d;
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
					
				}else
				{
					//Date转换为字符串
					Date d = (Date)value;
					return df.format(d);
				}
			}
			
		}, Date.class);
		BeanUtils.setProperty(s, "birthday", "1996-02-14");
		System.out.println(s.getBirthday());
	}
	@Test
	public void test51() throws Exception
	{
		Student s = new Student();
		//给BeanUtils注册类型转换器:自定义转换器
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(s, "birthday", "1996-02-14");
		System.out.println(s.getBirthday());
	}
}
