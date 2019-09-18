package cn.itcast.service;

import java.util.Map;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;

public interface BookService {
	Map<String,Book> findAllBooks();

	Book findBookById(String bookId);

	void addBooktoCart(Cart cart, Book book);

	void ChangeNum(Cart cart, String bookId, int num);

	void DelOneService(Cart cart, String bookId);
}
