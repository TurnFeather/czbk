package cn.itcast.cookie.app3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//显示书的详细内容
//向客户端写Cookie
public class ShowDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//显示详细内容
		String id = request.getParameter("id");
		Book book = BookDB.findBookById(id);
		out.write("详细内容:" + book);
		
		//向客户端写Cookie:		bookHistory=1-2-3
		
		String ids = makeIds(request,id);
		Cookie cookie = new Cookie("bookHistory",ids);
		cookie.setMaxAge(Integer.MAX_VALUE);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
	}

	private String makeIds(HttpServletRequest request, String id) {
		Cookie [] cookies = request.getCookies();
		if (cookies == null)
		{
			return id;
		}
		Cookie c = null;	//存放指定的bookHistory这个cookie
		for(Cookie cookie : cookies)
		{
			if ("bookHistory".equals(cookie.getName()))
			{
				c = cookie;
				break;
			}
		}
		if (c == null)
			return id;
		
		String value = c.getValue();
		String oldIds[] = value.split("\\-");
		
		for (int k=0;k<oldIds.length;k++)
			System.out.println("a:" + oldIds[k]);
		
		LinkedList<String> ll = new LinkedList<String>(Arrays.asList(oldIds));
		
		if (ll.size() < 3)
		{
			if (ll.contains(id))
			{
				ll.remove(id);
				
			}
			ll.addFirst(id);
		}
		else
		{
			if(ll.contains(id))
				ll.remove(id);
			else
				ll.removeLast();
			ll.addFirst(id);
		}
		
		StringBuffer str = new StringBuffer();
		for (int i=0;i<ll.size();i++)
		{
			if (i > 0)
				str.append("-");
			str.append(ll.get(i));
		}
		
		return str.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
