package cn.itcast.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
public class RequestServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ָ��ͷ��Ϣ�ֶ�Accept-Encoding
		String value = request.getHeader("Accept-Encoding");	//���ͷ��Ϣ���ڶ��ֵ�������ֵƴ�ӵ�һ���γ�String
		System.out.println(value);			//gzip, deflate
		
		System.out.println("--------------------------------------------------");
		//������е�ͷ��Ϣ����������-----�������ͷ��Ϣ������
		Enumeration<String> enumeration = request.getHeaderNames();
		while(enumeration.hasMoreElements())
		{
			String name = enumeration.nextElement();	//name����һ��ͷ��Ϣ������
			System.out.println(name + ":" + request.getHeader(name));
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
