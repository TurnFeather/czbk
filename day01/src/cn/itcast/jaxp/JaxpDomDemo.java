package cn.itcast.jaxp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//利用Jaxp进行Dom方式解析
public class JaxpDomDemo {

	public static void main(String[] args) throws Exception {
		//得到解析工厂DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//得到解析器DocumentBuilder
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析制定的XML文档，得到代表内存DOM树的Document对象
		Document document = builder.parse("src/book.xml");
		
		test8(document);
	}
	//1、得到某个具体的几点内容：打印第二本书的作者
	public static void test1(Document document)
	{
		//根据标签获取所有的作者元素
		NodeList nl = document.getElementsByTagName("作者");
		//按照索引取第二个作者元素
		Node node = nl.item(1);
		//打印该元素的文本
		String text = node.getTextContent();
		System.out.println(text);
	}
	//2、遍历所有元素节点：打印元素名称
	public static void test2(Node node)
	{
		if (node.getNodeType() == Node.ELEMENT_NODE)
		{
			System.out.println(node.getNodeName());
		}
		NodeList nl = node.getChildNodes();
		int len = nl.getLength();
		for (int i=0;i<len;i++)
		{
			Node n = nl.item(i);
			test2(n);
		}
	}
	//3、修改某个元素节点的主体内容： 把第一本书的售价改为250.00元
	public static void test3(Document document) throws Exception
	{
		NodeList nl = document.getElementsByTagName("售价");
		Node node = nl.item(0);
		node.setTextContent("250.00元");
		//将内存中的DOM对象树写会磁盘文件
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer ts = factory.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	//4、在第一本书中增加<内部价>99.00元</内部价>
	public static void test4(Document document) throws Exception
	{
		//创建一个新的元素并设置其主体内容
		Element e = document.createElement("内部价");
		e.setTextContent("500.00元");
		//找到第一本书元素
		NodeList nl = document.getElementsByTagName("书");
		Node n = nl.item(0);
		//把新节点挂接到第一本书上
		n.appendChild(e);
		//将内存中的DOM树写会到磁盘文件中去
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tr = factory.newTransformer();
		tr.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	//5、向指定元素节点上增加同级元素节点：在第一本书的售价前面增加批发价
	public static void test5(Document document) throws Exception
	{
		//1、创建一个新的元素并设置其中的主体内容
		Element n = document.createElement("批发价");
		n.setTextContent("58.00元");
		//找到第一本书售价的节点
		Node firstPrice = document.getElementsByTagName("售价").item(0);
		//在售价的前面加入新建的元素：增加子元素一定要使用父元素来做
		firstPrice.getParentNode().insertBefore(n, firstPrice);
		//把内存中的Document树写会到XML文件中
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	//6、删除指定元素节点：删除内部价
	public static void test6(Document document) throws Exception
	{
		//找到内部价节点，用父亲删除
		Node innerPrice = document.getElementsByTagName("内部价").item(0);
		innerPrice.getParentNode().removeChild(innerPrice);
		//把内存中的Document树写会XML文件中去
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	//7、操作XML文件的属性：打印第一本书的出版社
	public static void test7(Document document)
	{
		//得到第一本书
		Node first = document.getElementsByTagName("书").item(0);
		//打印指定属性的取值
		Element e = (Element)first;
		System.out.println(e.getAttribute("出版社"));
	}
	//8、操作XML文件的属性：在第二本书中添加出版社属性
		public static void test8(Document document) throws Exception
		{
			//得到第二本书
			Node second = document.getElementsByTagName("书").item(1);
			//打印指定属性的取值
			Element e = (Element)second;
			e.setAttribute("出版社", "人民教育出版社");
			//把内存中的Document树写会XML文件中去
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult("src/book.xml"));
		}
}
