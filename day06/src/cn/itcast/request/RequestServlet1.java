package cn.itcast.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ͨ��request��api��ÿͻ�����Ϣ
public class RequestServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//����һgetRequestURL��getRequestURI������
		System.out.println("url:" + request.getRequestURL());
		System.out.println("uri:" + request.getRequestURI());
		
		//��������˽�ͨ��getQueryString���Ի��get��ʽ�ύ�Ĳ�ѯ��
		System.out.println(request.getQueryString());
		
		//��ÿͻ��˵�IP
		System.out.println("�ͻ���IP��ַ:" + request.getRemoteAddr());
		
		//ͨ��getContentPath��ù�������Ŀ¼
		System.out.println(request.getContentType());	//����/day06
		
		//ͨ��getMethod()�������ʽ
		System.out.println(request.getMethod());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
