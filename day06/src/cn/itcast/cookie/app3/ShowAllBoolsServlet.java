package cn.itcast.cookie.app3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��ʾ���е���Ʒ
//��ʾ����������¼
public class ShowAllBoolsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ʾ������Ʒ
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>��վ�����º��飻</h1>");
		Map<String,Book> books = BookDB.findAllBooks();
		for (Map.Entry<String,Book>me : books.entrySet())
		{
			out.write(me.getValue().getName() + "&nbsp;<a href='/day06/servlet/ShowDetailServlet?id="+me.getKey()+"' target='_blank'>��ϸ</a><br/>");
		}
		
		//��ʾ�������ʷ��¼
		out.write("���������ʷ��¼Ϊ:<br/></br>");
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
