package cn.itcast.cookie.app3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//显示所有的商品
//显示最近的浏览记录
public class ShowAllBoolsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//显示所有商品
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>本站有以下好书；</h1>");
		Map<String,Book> books = BookDB.findAllBooks();
		for (Map.Entry<String,Book>me : books.entrySet())
		{
			out.write(me.getValue().getName() + "&nbsp;<a href='/day06/servlet/ShowDetailServlet?id="+me.getKey()+"' target='_blank'>详细</a><br/>");
		}
		
		//显示最近的历史记录
		out.write("你最近的历史记录为:<br/></br>");
		Cookie cookies[] = request.getCookies();
		for (int i=0;cookies!=null && i<cookies.length;i++)
		{
			if ("bookHistory".equals(cookies[i].getName()))
			{
				String value = cookies[i].getValue();		//1-2-3
				String ids[] = value.split("\\-");			//1 2 3
				for (String id : ids)
				{
					out.write("<a href='/day06/servlet/ShowDetailServlet?id="+id +"' target='_blank'>"+ BookDB.findBookById(id).getName()+"</a><br/>");
				}
				break;
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
