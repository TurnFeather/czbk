public class T1 
{ 
	public static void main ( String arg[] ) { 
		System.out.println(2.00-1.10);
		T2 t = new T2();
	} 
}

class TT
{
	//先初始化静态资源快
	static{
		int i = 0;
		String str = "abc";
		System.out.println("static block");
	}
	
	private String name;
	private static String abc = f();
	
	//在构造对象
	public TT()
	{
		System.out.println("T2 be created");
	}
	
	public static String f()
	{
		System.out.println("f() excuted");
		return "dd";
	}
}