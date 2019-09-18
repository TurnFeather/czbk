package cn.itcast.domain;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable 
{
	private String name;
	private String gender;
	private boolean married;
	Date birthday;
	
	public Person()
	{
		
	}
	
	public Person(String name, String gender, boolean married) {
		super();
		this.name = name;
		this.gender = gender;
		this.married = married;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
