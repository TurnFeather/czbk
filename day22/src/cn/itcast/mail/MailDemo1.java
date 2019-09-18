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
		Properties props = new Properties();	//���û��������������ʼ�ʱ��Ҫ
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);		//session�����ͻ���	message����һ���ʼ�
		
		message.setFrom(new InternetAddress("itheima14@163.com"));		//���÷�����
		message.setRecipients(Message.RecipientType.TO, "yurongchengs@163.com");	//�����ռ���
		message.setSubject("����JavaMail���͵ĵ�һ���ʼ�");		//��������
		
		//�����ʼ���������
		message.setText("�ٺ٣�JavaMail���͵��ʼ�����");
		
		//���ʼ��浽������
		
		message.writeTo(new FileOutputStream("D:\\1.eml"));
	}
}
