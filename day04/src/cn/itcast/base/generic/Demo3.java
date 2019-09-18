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
	//ֻ���������Ͳ�����Ϊ���ͷ�����ʵ�ʲ���
	@Test
	public void test2()
	{
		String t[]= {"a","b","c","d"};
		GenericUtil.reverse(t);			//ֻ���������Ͳ�����Ϊ���ͷ�����ʵ�ʲ���
		List list = Arrays.asList(t);
		System.out.println(list);
	}
	
	@Test
	public void test3()
	{
		int i[] = {1,2,3,4};
		List list = Arrays.asList(i);	//Arrays.asList���������ã��ǰ����������Ԫ�ر��list�����Ԫ�ء�
										//���ǣ������������飬������������Ϊlist �е�һ��Ԫ�ء�
		System.out.println(list);
		int [] ii = (int[]) list.get(0);
		for (int j : ii)
		{
			System.out.println(j);
		}
	}
}
