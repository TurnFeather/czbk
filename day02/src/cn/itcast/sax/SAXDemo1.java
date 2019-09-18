package cn.itcast.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

//JAXP����SAX����ԭ��ʵ��
public class SAXDemo1 {

	public static void main(String[] args) throws Exception, SAXException {
		//�õ���������SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//�õ�������SAXParser
		SAXParser parser = factory.newSAXParser();
		//�õ�XML��ȡ����XLMReader
		XMLReader reader = parser.getXMLReader();
		//ע�����ݴ�������ContentHandler
		reader.setContentHandler(new MyContentHandler());
		//��ʼ����
		reader.parse("src/book.xml");
	}

}

class MyContentHandler implements ContentHandler
{
	//�������ĵ���ʼʱ������
	public void startDocument() throws SAXException {
		System.out.println("���������ĵ��Ŀ�ʼ");
		
	}
	//�������ĵ�Ԫ�ؿ�ʼʱ������:qName���浱ǰԪ������
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("��������Ԫ�ؿ�ʼ��" + qName);
		
	}
	//�������ı�����ʱ������
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("���������ı���" + new String(ch,start,length));
		
	}
	//����������Ԫ��ʱ������
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("��������Ԫ�ؽ�����" + qName);
		
	}
	//�������ĵ�����ʱ������
	public void endDocument() throws SAXException {
		System.out.println("���������ĵ��Ľ���");
		
	}


	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		
		
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		
		
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		
	}

	public void processingInstruction(String target, String data) throws SAXException {
		
	}

	public void skippedEntity(String name) throws SAXException {
		
	}
	
	public void setDocumentLocator(Locator locator) {
		
	}
}
