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
		pw.write("��½�ɹ���2�����ת����ҳ����û����ת�����<a href='/day06/main.html'>����</a>");
	}
	
	//��ʱˢ�µ��Լ�
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
