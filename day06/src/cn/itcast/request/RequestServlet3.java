package cn.itcast.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//通过头信息来进行程序的防盗链
public class RequestServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//通过getHeader获得referer的头信息
		String referer = request.getHeader("referer");
		//判断头信息可以知道是不是盗链
		if (referer == null || !referer.startsWith("http://localhost"))
		{
			response.getWriter().write("是盗链");
		}
		else
			//不是盗链
			response.getWriter().write("这个真不是盗链");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
