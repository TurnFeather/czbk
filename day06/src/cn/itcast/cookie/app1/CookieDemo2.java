package cn.itcast.cookie.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		//显示上次记录的时间
		Cookie cookies[] = request.getCookies();
		response.getWriter().write("欢迎来到本站");
		for (int i=0;cookies!=null && i<cookies.length;i++)
		{
			if (cookies[i].getName().equals("lastAccessTime"));
			{
				String value = cookies[i].getValue();		//毫秒值
				long time = Long.parseLong(value);
				//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				//response.getWriter().write("你上次访问的时间为:" + df.format(new Date(time)));
				response.getWriter().write("你上次访问的时间为:" + (new Date(time)).toLocaleString());
			}
		}
		
		//向客户端一个特殊的Cookie，取值为当前的访问时间
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
