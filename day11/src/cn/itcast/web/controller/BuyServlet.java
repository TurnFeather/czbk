package cn.itcast.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.service.BookService;
import cn.itcast.service.impl.BookServiceImpl;

public class BuyServlet extends HttpServlet {
	
	private BookService s = new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String bookId = request.getParameter("bookId");
		Book book = s.findBookById(bookId);
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart == null)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		s.addBooktoCart(cart,book);
		out.write("[" + book.getName()+"]已经放入您的购物车。<a href='"+ request.getContextPath()+"'>继续购物</>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
