package cn.itcast.jdkproxy.sh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 拦截器
 * @author 14065
 *	1、引入目标类
 *	2、引入事务
 *	3、通过构造函数给目标类和事务赋值
 *	4、填充invoke方法
 */
public class PersonInterceptor implements InvocationHandler {
	private Object target;
	private Transaction transaction;
	
	public PersonInterceptor(Object target,Transaction transaction)
	{
		this.target = target;
		this.transaction = transaction;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		this.transaction.beginTransaction();
		method.invoke(this.target, args);		//调用目标类方法
		this.transaction.commit();
		return null;
	}

}
