package cn.itcast.base.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Demo1 
{
	@Test
	public void test1()
	{
		List list = new ArrayList();
		list.add(1);				//�Զ�װ�䣬�������治��װ��������
		list.add("fuck");

		Iterator iterator = list.iterator();
		while(iterator.hasNext())
		{
			Object obj = iterator.next();
			System.out.println(obj);
		}
	}
	@Test		//���ͱ���Map����ʽһ
	public void test3()
	{
		Map<Integer,String> map = new LinkedHashMap<Integer,String>();
		map.put(1, "aaa");
		map.put(2, "bbb");
		map.put(3, "ccc");
		
		Set<Integer> keys = map.keySet();
		for (Integer i : keys)
		{
			String value = map.get(i);
			System.out.println("key:" + i + "\tvalue:" + value);
		}
	}
	@Test		//���ͱ���Map����ʽ��
	public void test4()
	{
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		
		Set<Map.Entry<String, String>> set = map.entrySet();
		for (Map.Entry<String, String> me : set)
		{
			String key = me.getKey();
			String value = me.getValue();
			System.out.println("key:" + key + "\tvalue:" + value);
		}
	}
}
