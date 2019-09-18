package cn.itcast.service.impl;

import java.util.Map;

import cn.itcast.dao.BookDao;
import cn.itcast.dao.impl.BookDaoImpl;
import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao dao = new BookDaoImpl();
	public Map<String, Book> findAllBooks() {
		return dao.findAllBooks();
	}
	public Book findBookById(String bookId) {
		return dao.findBookById(bookId);
	}
	public void addBooktoCart(Cart cart, Book book) {
		cart.addBooktoCart(book);
	}
	public void ChangeNum(Cart cart, String bookId, int num) {
		cart.getItems().get(bookId).setNum(num);
		
	}
	public void DelOneService(Cart cart, String bookId) {
		cart.getItems().remove(bookId);
		
	}

}
