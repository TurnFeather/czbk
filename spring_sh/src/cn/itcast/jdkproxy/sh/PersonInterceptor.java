package cn.itcast.jdkproxy.sh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ������
 * @author 14065
 *	1������Ŀ����
 *	2����������
 *	3��ͨ�����캯����Ŀ���������ֵ
 *	4�����invoke����
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
		method.invoke(this.target, args);		//����Ŀ���෽��
		this.transaction.commit();
		return null;
	}

}
