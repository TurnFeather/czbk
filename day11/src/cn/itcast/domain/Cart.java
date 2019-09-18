package cn.itcast.domain;

import java.util.LinkedHashMap;
import java.util.Map;

//�����Ĺ��ﳵ
public class Cart {
	//key�ǹ��������е�ID��value�ǹ�����
	private Map<String,CartItem> items = new LinkedHashMap<String,CartItem>();
	private int num;	//������
	private float price;//�ܼ�
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
			//���ﳵ���Ѿ����Ȿ����
			CartItem item = items.get(book.getId());
			item.setNum(item.getNum() + 1);
		}
		else
		{
			//���ﳵ�л�û���Ȿ��
			CartItem item = new CartItem(book);
			item.setNum(1);
			items.put(book.getId(), item);
		}
	}
}
