package cn.itcast.base.introspector;

import java.util.Date;

public class Student {
	private String name = "���ٳ�";	//�ֶ�
	private int age;
	private Date birthday;
	//name����    ����ָ�������úͶ�ȡ�ֶεķ���
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//age����
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAbc()	//���ԣ�����������abc
	{
		return "abc";
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
