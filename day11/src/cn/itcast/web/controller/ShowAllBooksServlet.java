package cn.itcast.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Book;
import cn.itcast.service.impl.BookServiceImpl;
//控制器，查询所有的书籍
public class ShowAllBooksServlet extends HttpServlet {
	private BookServiceImpl s = new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,Book> books = s.findAllBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("/WEB-INF/pages/listBooks.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
