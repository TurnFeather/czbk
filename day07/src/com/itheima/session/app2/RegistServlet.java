package com.itheima.session.app2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//注册页面
public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//long l = System.currentTimeMillis();
		//String token = MD5Util.encode(l+"");
		String token = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", token);
		
		out.write("<form id='f1' action='/day07/servlet/AddServlet' method='get'>");
		out.write("用户名:<input type='text' name='username'/>");
		out.write("<input id='bt1' type='button' value='保存' onclick='toSubmit()'/>");
		out.write("<input type='hidden' name='token' value='"+ token +"'</form>");
		out.write("<script type='text/javascript'>");
		out.write("function toSubmit(){document.getElementById('bt1').disabled='disabled';document.getElementById('f1').submit();}");
		out.write("</script>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
