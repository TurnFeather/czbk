package cn.itcast.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test1(response);
	}
	//字符流输出中文数据
	private void test1(HttpServletResponse response) throws IOException {
		String str = "***要带摄像机";
		PrintWriter writer = response.getWriter();
		writer.write(str);	//在Servlet中默认查的时ISO-8859-1码表
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
