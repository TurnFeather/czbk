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
//�޸Ĺ����������
public class ChangeNumServlet extends HttpServlet {
	private BookService s = new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String bookId = request.getParameter("bookId");
			String newnum = request.getParameter("newnum");
			//�ҵ���
			Book book = s.findBookById(bookId);
			//�ҳ����ﳵ
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			int num = Integer.parseInt(newnum);
			if (num < 1)
			{
				request.setAttribute("message", "<script type='text/javascript'>alert('��������������')</script>");
			}
			else
				s.ChangeNum(cart, bookId, num);
		} catch (NumberFormatException e) {
			request.setAttribute("message", "<script type='text/javascript'>alert('��������ȷ��ʽ�����֣�')</script>");
		}
		request.getRequestDispatcher("/WEB-INF/pages/showCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
