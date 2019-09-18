package cn.itcast.sax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import cn.itcast.domain.Book;

//��ȡXML�е����ݣ���װ��JavaBean��
public class SAXDemo3 
{
	public static void main(String[] args) throws Exception, SAXException 
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		
		List<Book> list = new ArrayList<Book>();
		
		reader.setContentHandler(new DefaultHandler()
		{
			String currentTag = null;
			Book book = null;
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException
			{
				if ("��".equals(qName))
				{
					book = new Book();
				}
				currentTag = qName;
			}

			public void characters(char[] ch, int start, int length) throws SAXException {
				super.characters(ch, start, length);
				if ("����".equals(currentTag))
				{
					book.setName(new String(ch,start,length));
				}
				if ("����".equals(currentTag))
				{
					book.setAuthor(new String(ch,start,length));
				}
				if ("�ۼ�".equals(currentTag))
				{
					book.setPrice(Float.parseFloat((new String(ch,start,length))));
				}
			}	
			
			public void endElement(String uri, String localName, String qName) throws SAXException {
				super.endElement(uri, localName, qName);
				if ("��".equals(qName))
				{
					list.add(book);
					book = null;
				}
				currentTag = null;
			}
		});
		reader.parse("src/book.xml");
		for (Book b : list)
		{
			System.out.println(b);
		}
	}

}

//DefaultHandler��ʵ�ִ���
class MyDefaultContentHandler implements ContentHandler
{
	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	
}
