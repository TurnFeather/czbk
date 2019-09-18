package cn.itcast.mail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailDemo1 {
	public static void main(String [] args) throws Exception{
		Properties props = new Properties();	//设置环境变量，发送邮件时需要
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);		//session代表发送环境	message代表一封邮件
		
		message.setFrom(new InternetAddress("itheima14@163.com"));		//设置发件人
		message.setRecipients(Message.RecipientType.TO, "yurongchengs@163.com");	//设置收件人
		message.setSubject("这是JavaMail发送的第一封邮件");		//设置主题
		
		//设置邮件正文内容
		message.setText("嘿嘿！JavaMail发送的邮件来了");
		
		//把邮件存到磁盘上
		
		message.writeTo(new FileOutputStream("D:\\1.eml"));
	}
}
