package cn.itcast.base.introspector;

import java.util.Date;

public class Student {
	private String name = "余荣城";	//字段
	private int age;
	private Date birthday;
	//name属性    属性指的是设置和读取字段的方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//age属性
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAbc()	//属性：属性名称是abc
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
