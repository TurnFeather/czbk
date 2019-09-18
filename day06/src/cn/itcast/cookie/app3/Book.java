package cn.itcast.cookie.app3;

public class Book 
{
	private String id;
	private String name;
	private String author;
	private float price;
	private String desription;
	
	public Book()
	{
		
	}
	
	public Book(String id, String name, String author, float price,
			String desription) 
	{
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.desription = desription;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDesription() {
		return desription;
	}
	public void setDesription(String desription) {
		this.desription = desription;
	}
	
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", price=" + price + ", desription=" + desription + "]";
	}
}
