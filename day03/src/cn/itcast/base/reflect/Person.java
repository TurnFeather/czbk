package cn.itcast.base.reflect;

import java.util.Date;

public class Person 
{
	public String name = "���ǲ���";
	private int age = 10;
	public static Date time;
	
	public int getAge() {
		return age;
	}
	public Person()
	{
		System.out.println("Ĭ�Ϲ��췽��ִ����");
	}
	public Person(String name)
	{
		System.out.println("������" + name);
	}
	public Person(String name,int age)
	{
		System.out.println(name + "=" + age);
	}
	private Person(int age)
	{
		System.out.println("���䣺" + age);
	}
	public void m1()
	{
		System.out.println("m1");
	}
	public void m2(String name)
	{
		System.out.println(name);
	}
	public String m3(String name,int age)
	{
		System.out.println(name + ":" + age);
		return null;
	}
	private void m4(Date age)
	{
		System.out.println(age);
	}
	public static void m5()
	{
		System.out.println("m5");
	}
	private static void m6(String[] strs)
	{
		System.out.println(strs.length);
	}
}
