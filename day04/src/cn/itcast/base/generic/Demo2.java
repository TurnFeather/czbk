package cn.itcast.base.generic;

//在类上面声明泛型，只对实例方法有效,在实例方法上直接用就行，但是不适合静态方法。
public class Demo2<T> {
	public void m1(T t)
	{
		
	}
	public T m2(T t)
	{
		return null;
	}
	public static <T> T m3(T t)		//在静态方法上使用的泛型声明必须单独定义
	{
		return t;
	}
}
