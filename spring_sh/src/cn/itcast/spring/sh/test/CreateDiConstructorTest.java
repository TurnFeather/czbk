package cn.itcast.spring.sh.test;

import org.junit.Test;

import cn.itcast.spring.sh.di.constructor.Person;
import cn.itcast.spring.sh.util.SpringUtil;

public class CreateDiConstructorTest extends SpringUtil {
	@Test
	public void testDISet()
	{
		Person person = (Person)context.getBean("person_con");
		System.out.println("pid:" + person.getPid() + "\t" + 
				"pname:"+person.getPname());
		person.getStudent().sayHello();
	}
}
