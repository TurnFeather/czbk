package cn.itcast.mail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail2 {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();	//设置环境变量，发送邮件时需要
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.debug", "true");
		Session session = Session.getDefaultInstance(props,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("itheima14@163.com","iamsorry");		//Authentication 认证，鉴定
			}
			
		});
		MimeMessage message = new MimeMessage(session);		//session代表发送环境	message代表一封邮件
		
		message.setFrom(new InternetAddress("itheima14@163.com"));		//设置发件人
		message.setRecipients(Message.RecipientType.TO, "yurongchengs@163.com");	//设置收件人
		message.setSubject("这是JavaMail发送的第三封邮件");		//设置主题
		
		//设置邮件正文内容
		message.setText("嘿嘿！JavaMail发送的第三封邮件来了");
		
		//把邮件存到磁盘上
		
		Transport.send(message);
	}

}
