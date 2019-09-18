package cn.itcast.base.generic;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Demo3 {
	@Test
	public void test1()
	{
		String t[]= {"a","b","c"};
		GenericUtil.m1(t, 0, 2);
		List list = Arrays.asList(t);
		System.out.println(list);
	}
	//只有引用类型才能作为泛型方法的实际参数
	@Test
	public void test2()
	{
		String t[]= {"a","b","c","d"};
		GenericUtil.reverse(t);			//只有引用类型才能作为泛型方法的实际参数
		List list = Arrays.asList(t);
		System.out.println(list);
	}
	
	@Test
	public void test3()
	{
		int i[] = {1,2,3,4};
		List list = Arrays.asList(i);	//Arrays.asList方法的作用，是把数组里面的元素变成list里面的元素。
										//但是，基本类型数组，把整个数组作为list 中的一个元素。
		System.out.println(list);
		int [] ii = (int[]) list.get(0);
		for (int j : ii)
		{
			System.out.println(j);
		}
	}
}
