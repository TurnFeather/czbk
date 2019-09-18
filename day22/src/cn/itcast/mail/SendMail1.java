package cn.itcast.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail1 {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();	//设置环境变量，发送邮件时需要
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.163.com");		//发送服务器的主机地址
		
		props.setProperty("mail.smtp.auth", "true");		//请求身份验证
		
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);		//session代表发送环境	message代表一封邮件
		
		message.setFrom(new InternetAddress("itheima14@163.com"));		//设置发件人
		message.setRecipients(Message.RecipientType.TO, "yurongchengs@163.com");	//设置收件人
		message.setSubject("这是JavaMail发送的第一封邮件");		//设置主题
		
		//设置邮件正文内容
		message.setText("嘿嘿！JavaMail发送的邮件来了");
		message.saveChanges();
		//发送邮件
		Transport ts = session.getTransport();
		ts.connect("itheima14@163.com", "iamsorry");
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}
}
