package cn.itcast.domain;

import java.util.LinkedHashMap;
import java.util.Map;

//真正的购物车
public class Cart {
	//key是购物项书中的ID，value是购物项
	private Map<String,CartItem> items = new LinkedHashMap<String,CartItem>();
	private int num;	//总数量
	private float price;//总价
	public Map<String, CartItem> getItems() {
		return items;
	}
	/*public void setItems(Map<String, CartItem> items) {
		this.items = items;
	}*/
	public int getNum() {
		num = 0;
		for(Map.Entry<String, CartItem> me : items.entrySet())
		{
			num = me.getValue().getNum();
		}
		return num;
	}
	/*public void setNum(int num) {
		this.num = num;
	}*/
	public float getPrice() {
		price = 0;
		for(Map.Entry<String, CartItem> me : items.entrySet())
		{
			price = price + me.getValue().getPrice();
		}
		return price;
	}
	/*public void setPrice(float price) {
		this.price = price;
	}*/
	public void addBooktoCart(Book book)
	{
		if (items.containsKey(book.getId()))
		{
			//购物车中已经有这本书了
			CartItem item = items.get(book.getId());
			item.setNum(item.getNum() + 1);
		}
		else
		{
			//购物车中还没有这本书
			CartItem item = new CartItem(book);
			item.setNum(1);
			items.put(book.getId(), item);
		}
	}
}
