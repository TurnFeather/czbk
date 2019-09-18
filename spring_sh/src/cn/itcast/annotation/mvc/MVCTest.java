package cn.itcast.annotation.mvc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MVCTest {
	@Test
	public void testMVCAnnotation()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/annotation/mvc/applicationContext-mvc.xml");
		PersonAction pp = (PersonAction)context.getBean("personAction");
		pp.savePerson();
	}
}
