package cn.itcast.domain;
//������
public class CartItem {
	private Book book;
	private int num;
	private float price;	//С��
	
	public CartItem(Book book)
	{
		this.book = book;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		return num * book.getPrice();
	}
	/*public void setPrice(float price) {
		this.price = price;
	}*/
	
}
