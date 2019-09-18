package cn.itcast.spring.sh.test;

import org.junit.Test;

import cn.itcast.annotation.scan.Scan_Person;
import cn.itcast.spring.sh.util.SpringUtil;

public class CreateScanAnnotation extends SpringUtil {
	@Test
	public void testScanAnnotation()
	{
		Scan_Person scan_Person = (Scan_Person)context.getBean("scan_Person");
		scan_Person.getStudent().sayHello();
	}
}
