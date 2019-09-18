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

	//1���õ�ĳ������Ľڵ�����ݣ��ڶ����������
	@Test
	public void test1() throws Exception
	{
		//���Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		//��ø��ڵ�
		Element root = document.getRootElement();
		//���εõ��ڶ����������
		List<Element> list = root.elements("��");
		Element e = list.get(1);
		Element author = e.element("����");
		//�õ����ݴ�ӡ���
		//System.out.println(author.getText());
		Assert.assertEquals("������",author.getText());
	}
	@Test
	public void test11() throws Exception
	{
		//���Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		
		String xpath = "//��[2]/����";
		Node author = document.selectSingleNode(xpath);
		
		//�õ����ݴ�ӡ���
		//System.out.println(author.getText());
		Assert.assertEquals("������",author.getText());
	}
	//2����������Ԫ�ؽڵ�
	@Test
	public void test2() throws Exception
	{
		//�õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		//�õ���Ԫ��
		Element root = document.getRootElement();
		treeWalk(root);		//�������е�Ԫ�أ���ӡ��������
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
			Node node = ee.node(i);		//ȡ�����ϵĽڵ�
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				treeWalk((Element)node);
			}
		}
	}
	//3���޸�ĳ��Ԫ�ؽڵ����������:�޸ĵ�2������ۼ�
	@Test
	public void test3() throws Exception
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		//��õڶ�������ۼ�
		Element e = ((Element)root.elements().get(1)).element("�ۼ�");
		//������������
		e.setText("880.00");
		//д��XML�ĵ�
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(document);
		writer.close();
	}
	//4���޸�ĳ��Ԫ�ؽڵ���������Ԫ�ؽڵ�:����һ�������������
	@Test
	public void test4() throws Exception
	{
		//���Document����
		SAXReader reader = new SAXReader();
		Document doucment = reader.read("src/book.xml");
		//��õ�һ����ڵ�
		Element e = (Element)doucment.getRootElement().elements().get(0);
		//��������۽ڵ㣬����������������
		e.addElement("������").setText("100.00");
		//д��XML�ĵ�
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");	//ָ������ utf-8��Ĭ�ϵı���
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doucment);
		writer.close();
	}
	//5����ָ��Ԫ�ؽڵ�������ͬ��Ԫ�ؽڵ�:���ۼ�ǰ�߼����ڲ���
	@Test
	public void test5() throws Exception
	{
		//���Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		Element root = document.getRootElement();
		//��õ�һ����
		Element firstBook = root.element("��");
		//��õ�һ�����µ�������Ԫ��
		List<Element> list = firstBook.elements();
		//������Ҫ��ӵ�Ԫ��
		Element newElement = DocumentHelper.createElement("�ڲ���");
		newElement.setText("88.00");
		//����
		list.add(2, newElement);
		//д��XML�ĵ�
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(document);
		writer.close();
	}
	//6��ɾ��ָ��Ԫ�ؽڵ�:ɾ��������
	@Test
	public void test6() throws Exception
	{
		//�õ�Document����
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		//�õ���Ԫ��
		Element root = document.getRootElement();
		//�ҵ���һ����
		Element firstBook = root.element("��");
		//�ҵ�Ҫɾ����Ԫ��
		Element price = firstBook.element("������");
		//ɾ��Ԫ��,�Լ�����ɾ�Լ���Ҫ����ɾ��
		firstBook.remove(price);
		//д��XML�ĵ�
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(document);
		writer.close();
	}
	//7������XML�ļ�����:��һ�������һ������������
	@Test
	public void test7() throws Exception
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		
		Element root = document.getRootElement();
		Element firstBook = root.element("��");
		firstBook.addAttribute("������", "�й���ѧ������");
		
		//д��XML�ĵ�
		OutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(document);
		writer.close();
	}
	//7������XML�ļ�����:��õ�һ��������������ֵ
		@Test
		public void test8() throws Exception
		{
			SAXReader reader = new SAXReader();
			Document document = reader.read("src/book.xml");
			
			Element root = document.getRootElement();
			Element firstBook = root.element("��");
			
			Assert.assertEquals(firstBook.attributeValue("������"), "�й���ѧ������");
		}
}
