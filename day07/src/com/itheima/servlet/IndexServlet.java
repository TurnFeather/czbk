package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;

public class IndexServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		User user = (User)request.getSession().getAttribute("user");
		if (user == null)
		{
			out.write("你还没有登录，请点击<a href='" + request.getContextPath() + "/login.html'>登录</a>");
		}
		else
		{
			out.write("欢迎你:"+user.getUsername() + "<a href='/day07/servlet/LogoutServlet'>注销</a>");
		}
		out.write("<hr/>这是主页");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

}
