package cn.itcast.annotation.sh;

import java.lang.reflect.Method;

import org.junit.Test;

public class AnnotationParse {
	@Test
	public void testParse()
	{
		/**
		 * 解析注解的过程，我们就称为注解解析器
		 */
		
		Class class1 = ITCAST_SH.class;
		if(class1.isAnnotationPresent(Description.class))
		{
			Description description = (Description)class1.getAnnotation(Description.class);
			if(description.value().contains("注解"))
			{
				System.out.println("第一条注解解析成功");
			}
		}
		Method[] methods = class1.getMethods();
		for (Method m : methods)
		{
			if(m.isAnnotationPresent(MethodDesc.class))
			{
				MethodDesc method = m.getAnnotation(MethodDesc.class);
				if (method.name().contains("余荣城"))
				{
					System.out.println("第二条注解解析成功");
				}
			}
		}
	}
}
