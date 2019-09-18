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
		 * 1、目标类的类加载器
		 * 2、目标类实现的所有接口
		 * 3、拦截器
		 */
		PersonDao personDao = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);//产生的代理类       因为产生的代理类实现了目标类实现的所有接口，所以可以使用PersonDao接口来接收
		personDao.deletePerson();
	}
}
