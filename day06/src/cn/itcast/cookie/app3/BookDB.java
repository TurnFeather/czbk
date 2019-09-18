package cn.itcast.cookie.app3;

import java.util.HashMap;
import java.util.Map;

public class BookDB 
{
	//key:book��id value����Ӧ��book����
	private static Map<String,Book> books = new HashMap<String,Book>();
	static
	{
		books.put("1", new Book("1","��������","ţ��",5.00f,"�����˹����������û�����"));
		books.put("2", new Book("2","��Ʒ÷","������",15.00f,"�Ŵ�����С˵"));
		books.put("3", new Book("3","��Ů�ľ�","��ɺ��",5.00f,"�����˹��������崿"));
		books.put("4", new Book("4","Ƨа����","����",5.00f,"�����˹����������û�����"));
		books.put("5", new Book("5","JavaWeb����","���ٳ�",5.00f,"�����鼮"));
	}
	
	public static Map<String,Book> findAllBooks()
	{
		return books;
	}
	
	public static Book findBookById(String id)
	{
		return books.get(id);
	}
}
