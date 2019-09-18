package cn.itcast.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.cookie.app3.Book;
import cn.itcast.cookie.app3.BookDB;
//显示所有的商品，提供购买链接
public class ShowProductServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>本站有以下商品:</h1>");
		Map<String,Book> books = BookDB.findAllBooks();
		for (Map.Entry<String, Book> me : books.entrySet())
		{
			out.write(me.getValue().getName() + "&nbsp;&nbsp;<a href='/day06/servlet/BuyServlet?id="+me.getKey()+"'>购买</a><br/>");
		}
		out.write("<a href='" + request.getContextPath() + "/servlet/ShowCartServlet'>查看购物车</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
