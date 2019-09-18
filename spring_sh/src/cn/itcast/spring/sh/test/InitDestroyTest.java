package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.sh.initdestroy.HelloWorld;



public class InitDestroyTest {
	@Test
	public void testInitDestroy()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hello = (HelloWorld)context.getBean("helloWorld-initdestroy");
		hello.hello();
		
		HelloWorld hello2 = (HelloWorld)context.getBean("helloWorld-initdestroy");
		hello2.hello();
		ClassPathXmlApplicationContext temp = (ClassPathXmlApplicationContext)context;
		temp.close();
	}
}
