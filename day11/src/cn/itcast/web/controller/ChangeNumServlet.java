package cn.itcast.web.controller;

import java.io.IOException;
import java.util.IllegalFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.service.BookService;
import cn.itcast.service.impl.BookServiceImpl;
//修改购物项的数量
public class ChangeNumServlet extends HttpServlet {
	private BookService s = new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String bookId = request.getParameter("bookId");
			String newnum = request.getParameter("newnum");
			//找到书
			Book book = s.findBookById(bookId);
			//找出购物车
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			int num = Integer.parseInt(newnum);
			if (num < 1)
			{
				request.setAttribute("message", "<script type='text/javascript'>alert('请输入正整数！')</script>");
			}
			else
				s.ChangeNum(cart, bookId, num);
		} catch (NumberFormatException e) {
			request.setAttribute("message", "<script type='text/javascript'>alert('请输入正确格式的数字！')</script>");
		}
		request.getRequestDispatcher("/WEB-INF/pages/showCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
