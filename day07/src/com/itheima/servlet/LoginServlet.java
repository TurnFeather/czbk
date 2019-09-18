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
//������û��ĵ�¼
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");		//�û������
		String scode = (String)session.getAttribute("code");	//ͼƬ����ʱ�ŵ�session�����е�
		if (!code.equals(scode))
		{
			out.write("��֤�����");
			return;
		}
		
		
		User user = UserDB.findUser(username, password);
		if (user == null)
		{
			out.write("������û���������");
			return;
		}
		//��user����,��HttpSession������һ�����user
		
		session.setAttribute("user", user);
		//ת����ҳ
		response.sendRedirect(request.getContextPath() + "/servlet/IndexServlet");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
