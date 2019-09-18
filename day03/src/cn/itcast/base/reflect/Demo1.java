package cn.itcast.base.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class Demo1 {
	@Test
	public void test1() throws Exception
	{
		Class clazz =  Class.forName("cn.itcast.base.reflect.Person");
		Constructor cons = clazz.getConstructor(null);
		cons.newInstance(null);
	}
	@Test
	public void test11() throws Exception
	{
		Class<Person> clazz =  (Class<Person>) Class.forName("cn.itcast.base.reflect.Person");
		Person p = clazz.newInstance();
		System.out.println(p.name);
	}
	@Test
	public void test2() throws Exception
	{
		Class clazz =  Class.forName("cn.itcast.base.reflect.Person");
		Constructor cons = clazz.getConstructor(String.class);
		Person p = (Person)cons.newInstance("余荣城");
		System.out.println(p.name);
	}
	@Test
	public void test3() throws Exception
	{
		Class clazz =  Class.forName("cn.itcast.base.reflect.Person");
		Constructor cons = clazz.getConstructor(String.class,int.class);
		Person p = (Person)cons.newInstance("余荣城",21);
		System.out.println(p.name);
	}
	@Test
	public void test4() throws Exception
	{
		Class clazz =  Class.forName("cn.itcast.base.reflect.Person");
		Constructor cons = clazz.getDeclaredConstructor(int.class);
		cons.setAccessible(true);		//暴力反射
		Person p = (Person)cons.newInstance(21);
		System.out.println(p.name);
	}
	@Test
	public void test5() throws Exception
	{
		Class clazz =  Class.forName("cn.itcast.base.reflect.Person");
		Constructor[] cons = clazz.getDeclaredConstructors();
		System.out.println(cons.length);
	}
}
