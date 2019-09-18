package cn.itcast.cookie.app3;

import java.util.HashMap;
import java.util.Map;

public class BookDB 
{
	//key:book的id value：对应的book对象
	private static Map<String,Book> books = new HashMap<String,Book>();
	static
	{
		books.put("1", new Book("1","葵花宝典","牛羊",5.00f,"欲练此公，必须练好基本功"));
		books.put("2", new Book("2","金品梅","玉莲林",15.00f,"古代爱情小说"));
		books.put("3", new Book("3","玉女心经","黄珊汕",5.00f,"欲练此公，必须清纯"));
		books.put("4", new Book("4","僻邪剑谱","增号",5.00f,"欲练此公，必须练好基本功"));
		books.put("5", new Book("5","JavaWeb开发","余荣城",5.00f,"经典书籍"));
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
