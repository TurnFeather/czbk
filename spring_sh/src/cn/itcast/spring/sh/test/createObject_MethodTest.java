package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.sh.createobject.method.HelloWorld;


public class createObject_MethodTest {
	@Test
	public void testCreateObject()
	{
		/**
		 * 1、启动spring容器
		 * 2、从spring容器中把对象拿出来
		 * 3、调用对象方法
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hello = (HelloWorld)context.getBean("helloWorld-create-method");
		hello.hello();
		
		HelloWorld hello2 = (HelloWorld)context.getBean("helloWorld-create-factory-method");
		hello.hello();
	}
}
