package cn.itcast.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KickServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		Map<String,HttpSession> map = (Map<String,HttpSession>)getServletContext().getAttribute("users");
		if(map!=null){
			HttpSession session = map.get(name);
			if(session!=null){
				session.invalidate();
				map.remove(name);
			}
			
			getServletContext().getRequestDispatcher("/onlineuser.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
