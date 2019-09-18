package cn.itcast.db;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.itcast.domain.Book;

//ʵ�ʿ�������û�еġ����ݿ���ʵ�ֵ�
public class BookDB {
	private static Map<String,Book> books = new LinkedHashMap<String,Book>();
	static{
		books.put("001", new Book("001", "ISBN001", "��������", "������", 5.00f, "�����˹���������"));
		books.put("002", new Book("002", "ISBN002", "��а����", "������", 10.00f, "�����˹���������"));
		books.put("003", new Book("003", "ISBN003", "������", "���", 15.00f, "�����Ƿ����"));
		books.put("004", new Book("004", "ISBN004", "����ʮ����", "���", 100.00f, "���򷢴�"));
		books.put("005", new Book("005", "ISBN005", "JavaWeb����", "����ͥ", 6.00f, "��󷽷��Ķ�����"));
	}
	public static Map<String,Book> findAllBooks()
	{
		return books;
	}
	public static Book findBookById(String bookId)
	{
		return books.get(bookId);
	}
}
