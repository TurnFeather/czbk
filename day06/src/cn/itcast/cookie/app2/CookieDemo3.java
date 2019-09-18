package cn.itcast.cookie.app2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//展示登录界面，读取指定的cookie
public class CookieDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//读取指定的Cookie
		String username="";
		String checked="";
		Cookie cookies[] = request.getCookies();
		for (int i=0;cookies!=null&&i<cookies.length;i++)
		{
			Cookie cookie = cookies[i];
			if ("username".equals(cookie.getName()))
			{
				username = cookie.getValue();
				checked = "checked='checked'";
			}
		}
		System.out.println(username);
		System.out.println(checked);
		PrintWriter out = response.getWriter();
		out.write("<form action='/day06/servlet/CookieDemo4' method='get'>");
		out.write("username:<input type='text' name='username' value='"+ username +"'/></br>");
		out.write("password:<input type='password' name='password' value=''/></br>");
		out.write("remember:<input type='checkbox'name='remember' "+ checked+"/></br>");
		out.write("<input type='submit' value='save'/></form>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
