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
		//��ʾ�ϴμ�¼��ʱ��
		Cookie cookies[] = request.getCookies();
		response.getWriter().write("��ӭ������վ");
		for (int i=0;cookies!=null && i<cookies.length;i++)
		{
			if (cookies[i].getName().equals("lastAccessTime"));
			{
				String value = cookies[i].getValue();		//����ֵ
				long time = Long.parseLong(value);
				//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				//response.getWriter().write("���ϴη��ʵ�ʱ��Ϊ:" + df.format(new Date(time)));
				response.getWriter().write("���ϴη��ʵ�ʱ��Ϊ:" + (new Date(time)).toLocaleString());
			}
		}
		
		//��ͻ���һ�������Cookie��ȡֵΪ��ǰ�ķ���ʱ��
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
