package cn.itcast.dao;

import java.util.Map;

import cn.itcast.domain.Book;

/**
 * �鼮����DAO�ӿ�
 * @author 14065
 *
 */
public interface BookDao {
	/**
	 * ��ѯ���е���
	 * @return Map.key�����id��value����Ķ���
	 */
	Map<String,Book> findAllBooks();
	/**
	 * �������id��ѯ��
	 * @param bookId
	 * @return Book����
	 */
	Book findBookById(String bookId);
}
