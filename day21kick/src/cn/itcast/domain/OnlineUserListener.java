package cn.itcast.domain;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class OnlineUserListener implements HttpSessionAttributeListener {
	/*
	 只要向HttpSession的域中放东西都会执行该方法
	 我们要的是User对象，标记还是user的东东
	 找个地方存起来：容器要求唯一；页面上还能访问到该容器
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();
		ServletContext servlet = session.getServletContext();
		Object obj = session.getAttribute("user");
		if(obj!=null && obj instanceof User){
			//向容器中存起来
			Map<String,HttpSession> map = (Map<String,HttpSession>)servlet.getAttribute("users");	//存放东东的容器	Map<String,HttpSession> key:保存的是用户名 value：保存的是该用户对应的session对象
			if (map==null){//
				map = new HashMap<String,HttpSession>();
				servlet.setAttribute("users", map);
				System.out.println("嗯哼");
			}
			System.out.println("哈哈，我来了");
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
