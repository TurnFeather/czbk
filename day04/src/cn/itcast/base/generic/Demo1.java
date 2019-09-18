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
		list.add(1);				//自动装箱，集合里面不能装基本类型
		list.add("fuck");

		Iterator iterator = list.iterator();
		while(iterator.hasNext())
		{
			Object obj = iterator.next();
			System.out.println(obj);
		}
	}
	@Test		//泛型遍历Map，方式一
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
	@Test		//泛型遍历Map，方式二
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
