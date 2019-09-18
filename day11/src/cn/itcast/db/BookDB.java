package cn.itcast.db;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.itcast.domain.Book;

//实际开发中是没有的。数据库来实现的
public class BookDB {
	private static Map<String,Book> books = new LinkedHashMap<String,Book>();
	static{
		books.put("001", new Book("001", "ISBN001", "葵花宝典", "个服役", 5.00f, "欲练此功，必须买刀"));
		books.put("002", new Book("002", "ISBN002", "辟邪剑法", "网祥云", 10.00f, "欲练此功，必须买刀"));
		books.put("003", new Book("003", "ISBN003", "九阳神功", "于睿", 15.00f, "啊但是发达的"));
		books.put("004", new Book("004", "ISBN004", "降龙十八掌", "李大", 100.00f, "啊打发打发"));
		books.put("005", new Book("005", "ISBN005", "JavaWeb开发", "王朝庭", 6.00f, "大大方方的顶顶顶"));
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
