package cn.itcast.spring.sh.initdestroy;

public class HelloWorld {
	public HelloWorld()
	{
		System.out.println("initdestroy��Ĭ�Ϲ��췽��" + this);
	}
	
	public void init()
	{
		System.out.println("����ʼ��");
	}
	
	public void destroy()
	{
		System.out.println("���ͷ�" + this);
	}
	
	public void hello()
	{
		System.out.println("hello" + this);
	}
}
