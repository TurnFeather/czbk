package com.itheima;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String married = request.getParameter("married");
		String hobby[] = request.getParameterValues("hobby");
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		String id = request.getParameter("id");
		System.out.println(name);
		System.out.println(password);
		System.out.println(gender);
		System.out.println(married);
		System.out.println(hobby);
		System.out.println(address);
		System.out.println(description);
		System.out.println(id);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
