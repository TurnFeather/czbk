package cn.itcast.jdkproxy.sh;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void test()
	{
		Object target = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		PersonInterceptor interceptor = new PersonInterceptor(target,transaction);
		/**
		 * 1��Ŀ������������
		 * 2��Ŀ����ʵ�ֵ����нӿ�
		 * 3��������
		 */
		PersonDao personDao = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);//�����Ĵ�����       ��Ϊ�����Ĵ�����ʵ����Ŀ����ʵ�ֵ����нӿڣ����Կ���ʹ��PersonDao�ӿ�������
		personDao.deletePerson();
	}
}
