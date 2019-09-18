package cn.itcast.cookie.app2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//获得登录信息，并返回cookie
public class CookieDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//向数据库中进行校验
		String remember = request.getParameter("remember");
		
		Cookie cookie = new Cookie("username",username);
		cookie.setPath(request.getContextPath());
		if (remember != null)
		{
			System.out.println("yes");
			cookie.setMaxAge(Integer.MAX_VALUE);
		}
		else
		{
			System.out.println("no");
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		response.getWriter().write("登录成功");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
