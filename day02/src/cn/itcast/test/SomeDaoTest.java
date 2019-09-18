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
	
	//���һ�������ǲ��Է������������@Testע��
	//���Է�������û�з���ֵ����û���κβ�����
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

	@Test(timeout=2)	//��λ�Ǻ���
	public void testDivide2() {
		int result = dao.divide(6, 2);
		Assert.assertEquals(3, result);
	}
}
