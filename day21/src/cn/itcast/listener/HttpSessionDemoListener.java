package cn.itcast.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionDemoListener implements HttpSessionListener {
	//HttpSession对象被创建时调用
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session =  se.getSession();
		System.out.println(session + "对象被创建了");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session =  se.getSession();
		System.out.println(session + "对象被销毁了");
	}

}
