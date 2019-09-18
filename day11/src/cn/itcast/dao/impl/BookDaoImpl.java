package cn.itcast.dao.impl;

import java.util.Map;

import cn.itcast.dao.BookDao;
import cn.itcast.db.BookDB;
import cn.itcast.domain.Book;

public class BookDaoImpl implements BookDao {

	public Map<String, Book> findAllBooks() {
		// һϵ�в������ݿ�Ĵ���
		return BookDB.findAllBooks();
	}

	public Book findBookById(String bookId) {
		// TODO Auto-generated method stub
		return BookDB.findBookById(bookId);
	}

}
