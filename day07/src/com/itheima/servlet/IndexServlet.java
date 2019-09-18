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
			out.write("�㻹û�е�¼������<a href='" + request.getContextPath() + "/login.html'>��¼</a>");
		}
		else
		{
			out.write("��ӭ��:"+user.getUsername() + "<a href='/day07/servlet/LogoutServlet'>ע��</a>");
		}
		out.write("<hr/>������ҳ");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

}
