package cn.itcast.base.introspector;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

//����beanUtils��װ����
public class Demo2 {
	@Test
	public void test1() throws Exception
	{
		Map map = new HashMap();	//map�е�key������һ��
		map.put("name", "���ٳ�");
		map.put("age", "21");
		map.put("birthday", "1995-02-14");
		
		Person p = new Person();
		System.out.println("��װ����ǰ:" + p);
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(p, map);
		System.out.println("��װ���ݺ�:" + p);
	}
}
