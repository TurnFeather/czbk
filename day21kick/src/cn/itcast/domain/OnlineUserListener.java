package cn.itcast.domain;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class OnlineUserListener implements HttpSessionAttributeListener {
	/*
	 ֻҪ��HttpSession�����зŶ�������ִ�и÷���
	 ����Ҫ����User���󣬱�ǻ���user�Ķ���
	 �Ҹ��ط�������������Ҫ��Ψһ��ҳ���ϻ��ܷ��ʵ�������
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();
		ServletContext servlet = session.getServletContext();
		Object obj = session.getAttribute("user");
		if(obj!=null && obj instanceof User){
			//�������д�����
			Map<String,HttpSession> map = (Map<String,HttpSession>)servlet.getAttribute("users");	//��Ŷ���������	Map<String,HttpSession> key:��������û��� value��������Ǹ��û���Ӧ��session����
			if (map==null){//
				map = new HashMap<String,HttpSession>();
				servlet.setAttribute("users", map);
				System.out.println("�ź�");
			}
			System.out.println("������������");
			map.put(((User)obj).getName(), session);
			for(Map.Entry<String, HttpSession> me : map.entrySet())
				System.out.println(me.getKey() + "=" + me.getValue());
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {

	}

}
