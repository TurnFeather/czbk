package cn.itcast.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获得登陆用户名
		String username = request.getParameter("username");
		//验证用户名是否正确
		if (username!=null &&!username.trim().equals("")){
			User user = new User();
			user.setName(username);
			request.getSession().setAttribute("user", user);
			
			Map<String,HttpSession> map = (Map<String,HttpSession>)getServletContext().getAttribute("users");
			System.out.println("登陆Servlet");
			for (Map.Entry<String, HttpSession> me : map.entrySet()){
				System.out.println(me.getKey() + "=" + me.getValue());
			}
			
			getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
		}
		else{
			getServletContext().getRequestDispatcher(request.getContextPath() + "/error.jsp");
		}
	}
}
