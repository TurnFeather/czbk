package cn.itcast.spring.sh.test;

import org.junit.Test;

import cn.itcast.spring.sh.mvc.PersonAction;
import cn.itcast.spring.sh.util.SpringUtil;

public class createObjectMVC extends SpringUtil {
	@Test
	public void testMVC()
	{
		PersonAction personAction = (PersonAction)context.getBean("personAction");
		personAction.savePerson();
	}
}
