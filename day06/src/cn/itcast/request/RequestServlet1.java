package cn.itcast.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//通过request的api获得客户机信息
public class RequestServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//问题一getRequestURL和getRequestURI的区别
		System.out.println("url:" + request.getRequestURL());
		System.out.println("uri:" + request.getRequestURI());
		
		//问题二：了解通过getQueryString可以获得get方式提交的查询串
		System.out.println(request.getQueryString());
		
		//获得客户端的IP
		System.out.println("客户端IP地址:" + request.getRemoteAddr());
		
		//通过getContentPath获得工程虚拟目录
		System.out.println(request.getContentType());	//返回/day06
		
		//通过getMethod()获得请求方式
		System.out.println(request.getMethod());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
