package cn.itcast.test;

public class Test {
	public static void main(String[] args) {
		/*
		boolean a = false;
		boolean b = true;
		if (a && b) {
			// do something
			System.out.println("a&&b");
		}
		if (a & b) {
			// do something
			System.out.println("a&b");
		}
		*/
		A a = new B();
		a.printf();
	}
}

class A
{
	public A()
	{
		
	}
	public void printf()
	{
		System.out.println("A");
	}
}

class B extends A{
	
	public B()
	{
		super();
	}
	
	public void printf()
	{
		System.out.println("B");
	}
}
