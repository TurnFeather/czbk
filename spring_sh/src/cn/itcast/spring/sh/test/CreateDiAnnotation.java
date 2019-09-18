package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.annotation.di.Person;
import cn.itcast.spring.annotation.di.Student;
import cn.itcast.spring.sh.util.SpringUtil;

public class CreateDiAnnotation {
	@Test
	public void testDiAnnotation()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring/annotation/di/applicationContext-di-annotation.xml");
		Person person = (Person)context.getBean("person_annotation");
		/*
		Student student = (Student)context.getBean("student_annotation");
		student.sayHello();
		*/
		person.getStudent().sayHello();
		
	}
}
