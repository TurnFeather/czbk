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
	
	//以字节流用UTF-8编码向客户端输出中文数据
		private void test4(HttpServletResponse response) throws IOException {
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			String s = "这是一种新的方式";
			response.setContentType("text/html;charset='UTF-8");
			ServletOutputStream out = response.getOutputStream();
			out.write(s.getBytes("UTF-8"));
			out.close();
		}
	
	//以字节流用UTF-8编码向客户端输出中文数据
		private void test3(HttpServletResponse response) throws IOException {
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			String s = "大家好，这是傻逼";
			ServletOutputStream out = response.getOutputStream();
			out.write("<meta http-equiv='Content-Type' content='text/html;charset='UTF-8'>".getBytes());
			out.write(s.getBytes("UTF-8"));
			out.close();
		}
	
	//以字节流用UTF-8编码向客户端输出中文数据
	private void test2(HttpServletResponse response) throws IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		String s = "幸福与贫富无关";
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes("UTF-8"));
		out.close();
	}
	
	//以字节流用默认编码向客户端输出中文数据：木有乱码。
	private void test1(HttpServletResponse response) throws IOException {
		
		String s = "幸福时什么";
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes());
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
