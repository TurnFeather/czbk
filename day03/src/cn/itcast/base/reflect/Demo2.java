package cn.itcast.base.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

public class Demo2 {
	@Test
	public void test1() throws Exception
	{
		Class clazz = Class.forName("cn.itcast.base.reflect.Person");
		Person p = (Person)clazz.newInstance();
		Method method = clazz.getMethod("m1", null);
		method.invoke(p, null);
		
	}
	@Test
	public void test11() throws Exception
	{
		Class clazz = Class.forName("cn.itcast.base.reflect.Person");
		Method m = clazz.getMethod("m5", null);
		m.invoke(null, null);
	}
	@Test
	public void test2() throws Exception
	{
		Class clazz = Class.forName("cn.itcast.base.reflect.Person");
		Method m = clazz.getDeclaredMethod("m6", String[].class);
		String buffer[] = {"a","b","c"};
		m.setAccessible(true);
		//m.invoke(null, new Object[]{new String[]{"a","b"}});
		m.invoke(null, (Object)new String[]{"a","b"});
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
