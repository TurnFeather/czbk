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
	//�ַ��������������
	private void test1(HttpServletResponse response) throws IOException {
		String str = "***Ҫ�������";
		PrintWriter writer = response.getWriter();
		writer.write(str);	//��Servlet��Ĭ�ϲ��ʱISO-8859-1���
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
