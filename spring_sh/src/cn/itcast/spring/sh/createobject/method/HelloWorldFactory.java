package cn.itcast.spring.sh.createobject.method;

public class HelloWorldFactory {
	public HelloWorldFactory()
	{
		System.out.println("hello工厂类被创建");
	}
	public static HelloWorld getInstance()
	{
		return new HelloWorld();
	}
}
