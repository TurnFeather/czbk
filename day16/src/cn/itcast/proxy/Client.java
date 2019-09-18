package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String args[]){
		final Chun c = new Chun();
		
		//�ҵ�chun�Ķ�̬�����ࣨ�����ˣ�
		Human h = (Human)Proxy.newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//��������Ѳ�������30000
				if ("dance".equals(method.getName())){
					float money = (Float)args[0];
					if(money > 30000){
						c.dance(money);
					}
				}
				//��������Ѳ�������20000
				if ("dance".equals(method.getName())){
					float money = (Float)args[0];
					if(money > 20000){
						c.sing(money/2);
					}
				}
				return null;
			}
		});
		h.sing(40000);
		h.dance(60000);
	}
	
	
}
