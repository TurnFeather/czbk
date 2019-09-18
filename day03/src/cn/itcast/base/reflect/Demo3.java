package cn.itcast.base.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class Demo3 {
	@Test
	public void test1() throws Exception
	{
		Class clazz = Class.forName("cn.itcast.base.reflect.Person");
		Person p = (Person)clazz.newInstance();
		Field f = clazz.getField("name");
		String s = (String)f.get(p);
		System.out.println(s);
		f.set(p, (String)"…œ∫£¥¨÷ª");
		System.out.println(p.name);
	}
	@Test
	public void test11() throws Exception
	{
		
	}
	@Test
	public void test2() throws Exception
	{
		
	}
	@Test
	public void test3() throws Exception
	{
		
	}
	@Test
	public void test4() throws Exception
	{
		
	}
	@Test
	public void test5() throws Exception
	{
		
	}
}
