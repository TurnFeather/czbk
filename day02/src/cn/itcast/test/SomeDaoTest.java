package cn.itcast.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SomeDaoTest {

	SomeDao dao = null;
	@Before
	public void a()
	{
		System.out.println("aaa");
		dao = new SomeDao();
	}
	@After
	public void b()
	{
		System.out.println("bbb");
		dao = null;
	}
	
	//如果一个方法是测试方法，必须加上@Test注解
	//测试方法必须没有返回值，且没有任何参数的
	@Test
	public void testSum() {
		int result = dao.sum(2, 3);
		System.out.println(result);
	}

	@Test(expected=java.lang.ArithmeticException.class)
	public void testDivide() {
		int result = dao.divide(6, 0);
		Assert.assertEquals(3, result);
	}

	@Test(timeout=2)	//单位是毫秒
	public void testDivide2() {
		int result = dao.divide(6, 2);
		Assert.assertEquals(3, result);
	}
}
