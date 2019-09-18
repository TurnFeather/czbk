package cn.itcast.annotation.sh;

import java.lang.reflect.Method;

import org.junit.Test;

public class AnnotationParse {
	@Test
	public void testParse()
	{
		/**
		 * ����ע��Ĺ��̣����Ǿͳ�Ϊע�������
		 */
		
		Class class1 = ITCAST_SH.class;
		if(class1.isAnnotationPresent(Description.class))
		{
			Description description = (Description)class1.getAnnotation(Description.class);
			if(description.value().contains("ע��"))
			{
				System.out.println("��һ��ע������ɹ�");
			}
		}
		Method[] methods = class1.getMethods();
		for (Method m : methods)
		{
			if(m.isAnnotationPresent(MethodDesc.class))
			{
				MethodDesc method = m.getAnnotation(MethodDesc.class);
				if (method.name().contains("���ٳ�"))
				{
					System.out.println("�ڶ���ע������ɹ�");
				}
			}
		}
	}
}
