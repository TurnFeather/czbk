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
		Properties props = new Properties();	//���û��������������ʼ�ʱ��Ҫ
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);		//session�����ͻ���	message����һ���ʼ�
		
		message.setFrom(new InternetAddress("itheima14@163.com"));		//���÷�����
		message.setRecipients(Message.RecipientType.TO, "yurongchengs@163.com");	//�����ռ���
		message.setSubject("���Ǵ������ĸ����ʼ�");		//��������
		
		//�ı�����
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("�����������ı�aabcdef<img src='cid:mm'/>bedfdfa", "text/html;charset=UTF-8");
		//ͼƬ����
		MimeBodyPart imagePart = new MimeBodyPart();
		DataSource ds = new FileDataSource("E:/1.jpg");
		DataHandler dh = new DataHandler(ds);
		imagePart.setDataHandler(dh);
		imagePart.setContentID("mm");
		
		//���ı���ͼƬ������ϲ�����ϵ
		MimeMultipart mmpart1 = new MimeMultipart();
		mmpart1.addBodyPart(textPart);
		mmpart1.addBodyPart(imagePart);
		mmpart1.setSubType("related");
		
		//���ı�ͼƬ��ϰ�װ��BodyPart
		MimeBodyPart textImage = new MimeBodyPart();
		textImage.setContent(mmpart1);
		
		//��������
		MimeBodyPart attachMent = new MimeBodyPart();
		DataSource ds2 = new FileDataSource("E:/����.7z");
		DataHandler dh2 = new DataHandler(ds2);
		String fileName = dh2.getName();
		System.out.println(fileName);
		attachMent.setDataHandler(dh2);
		//To Do �����ļ���
		attachMent.setFileName(MimeUtility.encodeText(fileName));		//�ֹ������ļ����������ļ���Ҫע�����
		
		//ȫ������
		MimeMultipart mmpart2 = new MimeMultipart();
		mmpart2.addBodyPart(textImage);				//�ı�����ǶͼƬ
		mmpart2.addBodyPart(attachMent);			//����
		mmpart2.setSubType("mixed");				//���ӹ�ϵ
		
		message.setContent(mmpart2);
		message.saveChanges();
		message.writeTo(new FileOutputStream("E:/3.eml"));
	}
}
