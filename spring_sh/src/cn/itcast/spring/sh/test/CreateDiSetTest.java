package cn.itcast.spring.sh.test;

import org.junit.Test;

import cn.itcast.spring.sh.di.set.Person;
import cn.itcast.spring.sh.util.SpringUtil;

public class CreateDiSetTest extends SpringUtil {
	@Test
	public void testDISet()
	{
		Person person = (Person)context.getBean("person_set");
		System.out.println("pid:" + person.getPid() + "\t" + 
				"pname:"+person.getPname());
		person.getStudent().sayHello();
	}
}
