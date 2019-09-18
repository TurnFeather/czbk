package cn.itcast.session.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.cookie.app3.Book;
//显示购物车中的商品
public class ShowCartServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);	//有可能是null
		if (session == null)
		{
			out.write("对不起，你没有购买任何商品");
			return;
		}
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		if (cart == null || cart.size() < 1)
		{
			out.write("对不起，你没有购买任何商品");
			return;
		}
		out.write("你购买的商品如下<br/>");
		for (Book b : cart)
		{
			out.write(b.getName() + "<br/>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
}
