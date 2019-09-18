package cn.itcast.mail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//创建一封内嵌图片的文件
public class MailDemo2 {
	public static void main(String [] args) throws Exception{
		Properties props = new Properties();					//环境变量设置
		Session session = Session.getDefaultInstance(props);	//session代表发送环境
		MimeMessage message = new MimeMessage(session);	
		
		message.setSubject("这是一封文本中内嵌图片的邮件");		//设置主题
		
		//设置发件人，收件人
		message.setFrom(new InternetAddress("itheimat14@163.com"));
		message.setRecipients(MimeMessage.RecipientType.TO, "yurongchengs@163.com");
		
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("aaaa<img src='cid:mm'/>aaa", "text/html");
		
		MimeBodyPart imagePart = new MimeBodyPart();
		//把磁盘上的文件读到邮件中来：借助JAF框架
		DataHandler dh = new DataHandler(new FileDataSource("D:/1.jpg"));
		//通过JAF读取到的文件，不需要设置MIME类型，JAF框架会自动探测
		imagePart.setDataHandler(dh);
		
		imagePart.setContentID("mm");							//设置ID
		
		//描述二者的关系
		MimeMultipart mmpart = new MimeMultipart();
		mmpart.addBodyPart(textPart);
		mmpart.addBodyPart(imagePart);
		mmpart.setSubType("related");							//说明两部分是有关系的
		
		message.setContent(mmpart);
		message.saveChanges();
		message.writeTo(new FileOutputStream("D:/2.eml"));
	}
}
