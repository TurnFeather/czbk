package cn.itcast.annotation.document;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DocumentTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/annotation/document/applicationContext-document.xml");
		DocumentManager dd = (DocumentManager)context.getBean("documentManager");
		dd.writer();
	}
}
