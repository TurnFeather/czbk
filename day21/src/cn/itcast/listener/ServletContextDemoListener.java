package cn.itcast.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//�൱����
//public void contextInitialized(ServletContextEvent sce):�˷����еĴ�������Ӧ�ñ�����ʱִ�еģ�ִ��һ��
//��ˣ����԰�ϵͳ��һЩ��ʼ�������Ĵ���д�ڴ˴���------------------------------------------------------Ӧ�ó���
public class ServletContextDemoListener implements ServletContextListener {
	//��SerlvetContext��������ʱִ��
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext��������");
	}
	//��SerlvetContext���󱻴���ʱִ��
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext��������");
		init();
	}
	/*
	 <beans>
	 	<bean name="uDao" class="cn.itcast.dao.impl.UserDao"/>
	 	<bean name="uDao" class="cn.itcast.dao.impl.UserDao"/>
	 	<bean name="uDao" class="cn.itcast.dao.impl.UserDao"/>
	 	<bean name="uDao" class="cn.itcast.dao.impl.UserDao"/>
	 </beans>
	 */
	public void init(){//����Sprint��ʼ��ԭ��
		//Map<String,Object> : key��������������value��������
		//XML�ж�ȡ���е�beanԪ��
		//������ȡ��beanԪ�ص�nameֵ��classֵ
		//���÷��䣺Object obj = Class.forName(value).newInstance();
		//map.put(name,obj);
	}
}
