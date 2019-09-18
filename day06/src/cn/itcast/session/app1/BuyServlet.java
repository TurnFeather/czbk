package cn.itcast.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.cookie.app3.Book;
import cn.itcast.cookie.app3.BookDB;
//�ѹ������Ʒ�ŵ����ﳵ��
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("id:" + id);
		Book book = BookDB.findBookById(id);
		HttpSession session = request.getSession();
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		if (cart == null)
		{
			cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
		}
		cart.add(book);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("����ɹ�!<a href='/day06/servlet/ShowProductServlet'>��������</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
}
