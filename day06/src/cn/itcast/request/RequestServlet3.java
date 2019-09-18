package cn.itcast.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ͨ��ͷ��Ϣ�����г���ķ�����
public class RequestServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//ͨ��getHeader���referer��ͷ��Ϣ
		String referer = request.getHeader("referer");
		//�ж�ͷ��Ϣ����֪���ǲ��ǵ���
		if (referer == null || !referer.startsWith("http://localhost"))
		{
			response.getWriter().write("�ǵ���");
		}
		else
			//���ǵ���
			response.getWriter().write("����治�ǵ���");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
