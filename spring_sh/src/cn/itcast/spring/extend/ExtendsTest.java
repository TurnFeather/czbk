package cn.itcast.spring.extend;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExtendsTest {
	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring/extend/applicationContext.xml");
		PersonDao pp = (PersonDao)context.getBean("personDao");
		System.out.println(pp.getAbc());
	}
}
