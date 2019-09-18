package cn.itcast.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

//打印第二本书的作者出来
public class SAXDemo2 
{
	public static void main(String[] args) throws Exception, SAXException 
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		reader.setContentHandler(new ContentHandler()
		{	
			boolean isAuthor = false;		//是不是作者标签
			int index = 0;					//作者索引标签
			//解析到文档开始时被调用
			public void startDocument() throws SAXException 
			{
				System.out.println("解析到了文档的开始");
			}
			//解析道文档元素开始时被调用:qName保存当前元素名称
			public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException 
			{
				if ("作者".equals(qName))
				{
					isAuthor = true;
					index++;
				}
				
			}
			//解析到文本内容时被调用
			public void characters(char[] ch, int start, int length) throws SAXException 
			{
				//System.out.println("解析到了文本：" + new String(ch,start,length));
				if (isAuthor && index == 2)
				{
					System.out.println(new String(ch,start,length));
				}
				
			}
			//解析到结束元素时被调用
			public void endElement(String uri, String localName, String qName) throws SAXException 
			{
				//System.out.println("解析到了元素结束：" + qName);
				isAuthor = false;
			}
			//解析到文档结束时被调用
			public void endDocument() throws SAXException 
			{
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
		});
		reader.parse("src/book.xml");
	}

}
