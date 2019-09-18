package cn.itcast.mail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailDemo3 {
	public static void main(String [] args) throws Exception{
		Properties props = new Properties();	//设置环境变量，发送邮件时需要
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);		//session代表发送环境	message代表一封邮件
		
		message.setFrom(new InternetAddress("itheima14@163.com"));		//设置发件人
		message.setRecipients(Message.RecipientType.TO, "yurongchengs@163.com");	//设置收件人
		message.setSubject("这是带附件的复杂邮件");		//设置主题
		
		//文本部分
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("哈哈，我是文本aabcdef<img src='cid:mm'/>bedfdfa", "text/html;charset=UTF-8");
		//图片部分
		MimeBodyPart imagePart = new MimeBodyPart();
		DataSource ds = new FileDataSource("E:/1.jpg");
		DataHandler dh = new DataHandler(ds);
		imagePart.setDataHandler(dh);
		imagePart.setContentID("mm");
		
		//将文本与图片部分组合产生关系
		MimeMultipart mmpart1 = new MimeMultipart();
		mmpart1.addBodyPart(textPart);
		mmpart1.addBodyPart(imagePart);
		mmpart1.setSubType("related");
		
		//将文本图片组合包装成BodyPart
		MimeBodyPart textImage = new MimeBodyPart();
		textImage.setContent(mmpart1);
		
		//附件部分
		MimeBodyPart attachMent = new MimeBodyPart();
		DataSource ds2 = new FileDataSource("E:/附件.7z");
		DataHandler dh2 = new DataHandler(ds2);
		String fileName = dh2.getName();
		System.out.println(fileName);
		attachMent.setDataHandler(dh2);
		//To Do 设置文件名
		attachMent.setFileName(MimeUtility.encodeText(fileName));		//手工设置文件名，中文文件名要注意编码
		
		//全部合体
		MimeMultipart mmpart2 = new MimeMultipart();
		mmpart2.addBodyPart(textImage);				//文本加内嵌图片
		mmpart2.addBodyPart(attachMent);			//附件
		mmpart2.setSubType("mixed");				//复杂关系
		
		message.setContent(mmpart2);
		message.saveChanges();
		message.writeTo(new FileOutputStream("E:/3.eml"));
	}
}
