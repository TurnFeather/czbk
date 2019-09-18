package cn.itcast.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//����ת������һ������ת������һ��Servlet����Ϊ������������
//ͨ��AServlet����һ�����ݸ�BServlet
public class AServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ͨ��request������д���
		//��request����󱣴�һ������
		request.setAttribute("name", "yurongcheng");
		
		//�������ݸ�BServlet����ʹ������ת��
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/BServlet");
		dispatcher.forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
