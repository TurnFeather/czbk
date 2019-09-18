package cn.itcast.base.introspector;

import java.util.Date;

public class Person {
	private String name1;
	private int age;
	private Date birthday;
	public String getName() {
		return name1;
	}
	public void setName(String name) {
		this.name1 = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Person [name1=" + name1 + ", age=" + age + ", birthday="
				+ birthday + "]";
	}
	
}
