package cn.itcast.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Assert;
import org.junit.Test;

public class Dom4JDemo {

	//1、得到某个具体的节点的内容：第二本书的作者
	@Test
	public void test1() throws Exception
	{
		//获得Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		//获得根节点
		Element root = document.getRootElement();
		//依次得到第二本书的作者
		List<Element> list = root.elements("书");
		Element e = list.get(1);
		Element author = e.element("作者");
		//拿到内容打印输出
		//System.out.println(author.getText());
		Assert.assertEquals("余先生",author.getText());
	}
	@Test
	public void test11() throws Exception
	{
		//获得Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		
		String xpath = "//书[2]/作者";
		Node author = document.selectSingleNode(xpath);
		
		//拿到内容打印输出
		//System.out.println(author.getText());
		Assert.assertEquals("余先生",author.getText());
	}
	//2、遍历所有元素节点
	@Test
	public void test2() throws Exception
	{
		//得到Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		//得到根元素
		Element root = document.getRootElement();
		treeWalk(root);		//遍历所有的元素，打印他的名称
	}
	/*
	private void treeWalk(Element e)
	{
		System.out.println(e.getName());
		List<Element> list = e.elements();
		for (Element ee : list)
		{
			treeWalk(ee);
		}
	}*/
	private void treeWalk(Element ee)
	{
		System.out.println(ee.getName());
		int count = ee.nodeCount();
		for (int i=0;i<count;i++)
		{
			Node node = ee.node(i);		//取索引上的节点
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				treeWalk((Element)node);
			}
		}
	}
	//3、修改某个元素节点的主体内容:修改第2本书的售价
	@Test
	public void test3() throws Exception
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		//获得第二本书的售价
		Element e = ((Element)root.elements().get(1)).element("售价");
		//设置主体内容
		e.setText("880.00");
		//写会XML文档
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(document);
		writer.close();
	}
	//4、修改某个元素节点中增加子元素节点:给第一本书添加批发价
	@Test
	public void test4() throws Exception
	{
		//获得Document对象
		SAXReader reader = new SAXReader();
		Document doucment = reader.read("src/book.xml");
		//获得第一本书节点
		Element e = (Element)doucment.getRootElement().elements().get(0);
		//添加批发价节点，并设置批发价内容
		e.addElement("批发价").setText("100.00");
		//写会XML文档
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");	//指定编码 utf-8是默认的编码
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doucment);
		writer.close();
	}
	//5、向指定元素节点上增加同级元素节点:在售价前边加入内部价
	@Test
	public void test5() throws Exception
	{
		//获得Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		//获得第一本书
		Element firstBook = root.element("书");
		//获得第一本书下的所有子元素
		List<Element> list = firstBook.elements();
		//创建需要添加的元素
		Element newElement = DocumentHelper.createElement("内部价");
		newElement.setText("88.00");
		//插入
		list.add(2, newElement);
		//写会XML文档
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(document);
		writer.close();
	}
	//6、删除指定元素节点:删除批发价
	@Test
	public void test6() throws Exception
	{
		//得到Document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		//得到根元素
		Element root = document.getRootElement();
		//找到第一本书
		Element firstBook = root.element("书");
		//找到要删除的元素
		Element price = firstBook.element("批发价");
		//删除元素,自己不能删自己，要父亲删除
		firstBook.remove(price);
		//写回XML文档
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(document);
		writer.close();
	}
	//7、操作XML文件属性:第一本书添加一个出版社属性
	@Test
	public void test7() throws Exception
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		
		Element root = document.getRootElement();
		Element firstBook = root.element("书");
		firstBook.addAttribute("出版社", "中国科学出版社");
		
		//写回XML文档
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(document);
		writer.close();
	}
	//7、操作XML文件属性:获得第一本书出版社的属性值
		@Test
		public void test8() throws Exception
		{
			SAXReader reader = new SAXReader();
			Document document = reader.read("src/book.xml");
			
			Element root = document.getRootElement();
			Element firstBook = root.element("书");
			
			Assert.assertEquals(firstBook.attributeValue("出版社"), "中国科学出版社");
		}
}
