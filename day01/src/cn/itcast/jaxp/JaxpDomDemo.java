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

//����Jaxp����Dom��ʽ����
public class JaxpDomDemo {

	public static void main(String[] args) throws Exception {
		//�õ���������DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//�õ�������DocumentBuilder
		DocumentBuilder builder = factory.newDocumentBuilder();
		//�����ƶ���XML�ĵ����õ������ڴ�DOM����Document����
		Document document = builder.parse("src/book.xml");
		
		test8(document);
	}
	//1���õ�ĳ������ļ������ݣ���ӡ�ڶ����������
	public static void test1(Document document)
	{
		//���ݱ�ǩ��ȡ���е�����Ԫ��
		NodeList nl = document.getElementsByTagName("����");
		//��������ȡ�ڶ�������Ԫ��
		Node node = nl.item(1);
		//��ӡ��Ԫ�ص��ı�
		String text = node.getTextContent();
		System.out.println(text);
	}
	//2����������Ԫ�ؽڵ㣺��ӡԪ������
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
	//3���޸�ĳ��Ԫ�ؽڵ���������ݣ� �ѵ�һ������ۼ۸�Ϊ250.00Ԫ
	public static void test3(Document document) throws Exception
	{
		NodeList nl = document.getElementsByTagName("�ۼ�");
		Node node = nl.item(0);
		node.setTextContent("250.00Ԫ");
		//���ڴ��е�DOM������д������ļ�
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer ts = factory.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	//4���ڵ�һ����������<�ڲ���>99.00Ԫ</�ڲ���>
	public static void test4(Document document) throws Exception
	{
		//����һ���µ�Ԫ�ز���������������
		Element e = document.createElement("�ڲ���");
		e.setTextContent("500.00Ԫ");
		//�ҵ���һ����Ԫ��
		NodeList nl = document.getElementsByTagName("��");
		Node n = nl.item(0);
		//���½ڵ�ҽӵ���һ������
		n.appendChild(e);
		//���ڴ��е�DOM��д�ᵽ�����ļ���ȥ
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tr = factory.newTransformer();
		tr.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	//5����ָ��Ԫ�ؽڵ�������ͬ��Ԫ�ؽڵ㣺�ڵ�һ������ۼ�ǰ������������
	public static void test5(Document document) throws Exception
	{
		//1������һ���µ�Ԫ�ز��������е���������
		Element n = document.createElement("������");
		n.setTextContent("58.00Ԫ");
		//�ҵ���һ�����ۼ۵Ľڵ�
		Node firstPrice = document.getElementsByTagName("�ۼ�").item(0);
		//���ۼ۵�ǰ������½���Ԫ�أ�������Ԫ��һ��Ҫʹ�ø�Ԫ������
		firstPrice.getParentNode().insertBefore(n, firstPrice);
		//���ڴ��е�Document��д�ᵽXML�ļ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	//6��ɾ��ָ��Ԫ�ؽڵ㣺ɾ���ڲ���
	public static void test6(Document document) throws Exception
	{
		//�ҵ��ڲ��۽ڵ㣬�ø���ɾ��
		Node innerPrice = document.getElementsByTagName("�ڲ���").item(0);
		innerPrice.getParentNode().removeChild(innerPrice);
		//���ڴ��е�Document��д��XML�ļ���ȥ
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	//7������XML�ļ������ԣ���ӡ��һ����ĳ�����
	public static void test7(Document document)
	{
		//�õ���һ����
		Node first = document.getElementsByTagName("��").item(0);
		//��ӡָ�����Ե�ȡֵ
		Element e = (Element)first;
		System.out.println(e.getAttribute("������"));
	}
	//8������XML�ļ������ԣ��ڵڶ���������ӳ���������
		public static void test8(Document document) throws Exception
		{
			//�õ��ڶ�����
			Node second = document.getElementsByTagName("��").item(1);
			//��ӡָ�����Ե�ȡֵ
			Element e = (Element)second;
			e.setAttribute("������", "�������������");
			//���ڴ��е�Document��д��XML�ļ���ȥ
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult("src/book.xml"));
		}
}
