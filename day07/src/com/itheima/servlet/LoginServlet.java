package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;
import com.itheima.domain.UserDB;
//完成了用户的登录
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");		//用户输入的
		String scode = (String)session.getAttribute("code");	//图片生成时放到session对象中的
		if (!code.equals(scode))
		{
			out.write("验证码错误");
			return;
		}
		
		
		User user = UserDB.findUser(username, password);
		if (user == null)
		{
			out.write("错误的用户名或密码");
			return;
		}
		//有user对象,再HttpSession中设置一个标记user
		
		session.setAttribute("user", user);
		//转向主页
		response.sendRedirect(request.getContextPath() + "/servlet/IndexServlet");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
