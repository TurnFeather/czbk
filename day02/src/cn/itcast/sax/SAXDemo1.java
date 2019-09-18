package cn.itcast.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

//JAXP进行SAX解析原理实例
public class SAXDemo1 {

	public static void main(String[] args) throws Exception, SAXException {
		//得到解析工厂SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//得到解析器SAXParser
		SAXParser parser = factory.newSAXParser();
		//得到XML读取器：XLMReader
		XMLReader reader = parser.getXMLReader();
		//注册内容处理器：ContentHandler
		reader.setContentHandler(new MyContentHandler());
		//开始解析
		reader.parse("src/book.xml");
	}

}

class MyContentHandler implements ContentHandler
{
	//解析到文档开始时被调用
	public void startDocument() throws SAXException {
		System.out.println("解析到了文档的开始");
		
	}
	//解析道文档元素开始时被调用:qName保存当前元素名称
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("解析到了元素开始：" + qName);
		
	}
	//解析到文本内容时被调用
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("解析到了文本：" + new String(ch,start,length));
		
	}
	//解析到结束元素时被调用
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("解析到了元素结束：" + qName);
		
	}
	//解析到文档结束时被调用
	public void endDocument() throws SAXException {
		System.out.println("解析到了文档的结束");
		
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
