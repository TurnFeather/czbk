package cn.itcast.util;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

//����XML�Ĺ�����
//�������е��쳣������Ҳ���Դ���
public class DocumentUtil {
	public static Document getDocument() throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		return builder.parse("src/exam.xml");
	}

	public static void write2xml(Document document) throws Exception {
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/exam.xml"));
	}
}