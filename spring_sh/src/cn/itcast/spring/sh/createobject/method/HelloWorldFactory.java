package cn.itcast.spring.sh.createobject.method;

public class HelloWorldFactory {
	public HelloWorldFactory()
	{
		System.out.println("hello�����౻����");
	}
	public static HelloWorld getInstance()
	{
		return new HelloWorld();
	}
}
