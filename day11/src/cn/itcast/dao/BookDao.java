package cn.itcast.dao;

import java.util.Map;

import cn.itcast.domain.Book;

/**
 * 书籍操作DAO接口
 * @author 14065
 *
 */
public interface BookDao {
	/**
	 * 查询所有的书
	 * @return Map.key是书的id。value是书的对象。
	 */
	Map<String,Book> findAllBooks();
	/**
	 * 根据书的id查询书
	 * @param bookId
	 * @return Book对象
	 */
	Book findBookById(String bookId);
}
