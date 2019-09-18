package com.itheima.session.app2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String token = request.getParameter("token");
		String tokens = (String) request.getSession().getAttribute("token");
		if (!token.equals(tokens))
		{
			System.out.println("请不要重复提交");
			return ;
		}
		else
		{
			request.getSession().removeAttribute("token");
			String username = request.getParameter("username");
			System.out.println("保存了:" + username);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
