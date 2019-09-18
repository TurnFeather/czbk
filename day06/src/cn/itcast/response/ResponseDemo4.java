package cn.itcast.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test2(response);
	}
	
	private void test2(HttpServletResponse response) throws IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Refresh", "2;URL=/day06/main.html");
		
		
		PrintWriter pw = response.getWriter();
		pw.write("登陆成功！2秒后将跳转到主页！若没有跳转，请点<a href='/day06/main.html'>这里</a>");
	}
	
	//定时刷新到自己
	private void test1(HttpServletResponse response) throws IOException {
		//response.setHeader("Refresh", "1");
		response.setIntHeader("Refresh", 1);
		Random r = new Random();
		int i = r.nextInt();
		
		response.getOutputStream().write((i+"").getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
