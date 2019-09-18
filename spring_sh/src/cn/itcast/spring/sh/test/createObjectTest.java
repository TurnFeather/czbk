package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.sh.createobject.method.HelloWorld;


public class createObjectTest {
	@Test
	public void testCreateObject()
	{
		/**
		 * 1������spring����
		 * 2����spring�����аѶ����ó���
		 * 3�����ö��󷽷�
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hello = (HelloWorld)context.getBean("��������");
		hello.hello();
	}
}
