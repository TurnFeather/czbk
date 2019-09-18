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
		Properties props = new Properties();	//���û��������������ʼ�ʱ��Ҫ
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.debug", "true");
		Session session = Session.getDefaultInstance(props,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("itheima14@163.com","iamsorry");		//Authentication ��֤������
			}
			
		});
		MimeMessage message = new MimeMessage(session);		//session�����ͻ���	message����һ���ʼ�
		
		message.setFrom(new InternetAddress("itheima14@163.com"));		//���÷�����
		message.setRecipients(Message.RecipientType.TO, "yurongchengs@163.com");	//�����ռ���
		message.setSubject("����JavaMail���͵ĵ������ʼ�");		//��������
		
		//�����ʼ���������
		message.setText("�ٺ٣�JavaMail���͵ĵ������ʼ�����");
		
		//���ʼ��浽������
		
		Transport.send(message);
	}

}
