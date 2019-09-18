package cn.itcast.proxy.sh;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void test()
	{
		PersonDao personDao = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		
		PersonDao proxy = new PersonDaoProxy(personDao,transaction);
		proxy.savePerson();
		proxy.updatePerson();
		proxy.deletePerson();
	}
}
