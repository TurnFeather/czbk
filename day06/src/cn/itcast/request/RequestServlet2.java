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
		//获得指定头信息字段Accept-Encoding
		String value = request.getHeader("Accept-Encoding");	//如果头信息存在多个值，将多个值拼接到一起，形成String
		System.out.println(value);			//gzip, deflate
		
		System.out.println("--------------------------------------------------");
		//获得所有的头信息和它的内容-----获得所有头信息的名称
		Enumeration<String> enumeration = request.getHeaderNames();
		while(enumeration.hasMoreElements())
		{
			String name = enumeration.nextElement();	//name就是一个头信息的名字
			System.out.println(name + ":" + request.getHeader(name));
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
