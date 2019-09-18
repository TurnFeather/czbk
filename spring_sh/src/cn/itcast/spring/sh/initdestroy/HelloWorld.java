package cn.itcast.spring.sh.initdestroy;

public class HelloWorld {
	public HelloWorld()
	{
		System.out.println("initdestroy的默认构造方法" + this);
	}
	
	public void init()
	{
		System.out.println("被初始化");
	}
	
	public void destroy()
	{
		System.out.println("被释放" + this);
	}
	
	public void hello()
	{
		System.out.println("hello" + this);
	}
}
