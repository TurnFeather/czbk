package cn.itcast.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test4(response);
	}
	
	//���ֽ�����UTF-8������ͻ��������������
		private void test4(HttpServletResponse response) throws IOException {
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			String s = "����һ���µķ�ʽ";
			response.setContentType("text/html;charset='UTF-8");
			ServletOutputStream out = response.getOutputStream();
			out.write(s.getBytes("UTF-8"));
			out.close();
		}
	
	//���ֽ�����UTF-8������ͻ��������������
		private void test3(HttpServletResponse response) throws IOException {
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			String s = "��Һã�����ɵ��";
			ServletOutputStream out = response.getOutputStream();
			out.write("<meta http-equiv='Content-Type' content='text/html;charset='UTF-8'>".getBytes());
			out.write(s.getBytes("UTF-8"));
			out.close();
		}
	
	//���ֽ�����UTF-8������ͻ��������������
	private void test2(HttpServletResponse response) throws IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		String s = "�Ҹ���ƶ���޹�";
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes("UTF-8"));
		out.close();
	}
	
	//���ֽ�����Ĭ�ϱ�����ͻ�������������ݣ�ľ�����롣
	private void test1(HttpServletResponse response) throws IOException {
		
		String s = "�Ҹ�ʱʲô";
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes());
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
