package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String args[]){
		final Chun c = new Chun();
		
		//找到chun的动态代理类（经纪人）
		Human h = (Human)Proxy.newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//跳舞出场费不能少于30000
				if ("dance".equals(method.getName())){
					float money = (Float)args[0];
					if(money > 30000){
						c.dance(money);
					}
				}
				//唱歌出场费不能少于20000
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
