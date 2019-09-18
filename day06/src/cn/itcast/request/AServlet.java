package cn.itcast.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//请求转发，把一个请求转发给另一个Servlet。因为数据在请求里
//通过AServlet传递一个数据给BServlet
public class AServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//通过request对象进行传递
		//向request域对象保存一个属性
		request.setAttribute("name", "yurongcheng");
		
		//传递数据给BServlet必须使用请求转发
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/BServlet");
		dispatcher.forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
