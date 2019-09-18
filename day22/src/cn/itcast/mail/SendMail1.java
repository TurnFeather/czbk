package cn.itcast.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail1 {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();	//���û��������������ʼ�ʱ��Ҫ
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.163.com");		//���ͷ�������������ַ
		
		props.setProperty("mail.smtp.auth", "true");		//���������֤
		
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);		//session�����ͻ���	message����һ���ʼ�
		
		message.setFrom(new InternetAddress("itheima14@163.com"));		//���÷�����
		message.setRecipients(Message.RecipientType.TO, "yurongchengs@163.com");	//�����ռ���
		message.setSubject("����JavaMail���͵ĵ�һ���ʼ�");		//��������
		
		//�����ʼ���������
		message.setText("�ٺ٣�JavaMail���͵��ʼ�����");
		message.saveChanges();
		//�����ʼ�
		Transport ts = session.getTransport();
		ts.connect("itheima14@163.com", "iamsorry");
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}
}
