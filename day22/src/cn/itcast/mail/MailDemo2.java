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

//����һ����ǶͼƬ���ļ�
public class MailDemo2 {
	public static void main(String [] args) throws Exception{
		Properties props = new Properties();					//������������
		Session session = Session.getDefaultInstance(props);	//session�����ͻ���
		MimeMessage message = new MimeMessage(session);	
		
		message.setSubject("����һ���ı�����ǶͼƬ���ʼ�");		//��������
		
		//���÷����ˣ��ռ���
		message.setFrom(new InternetAddress("itheimat14@163.com"));
		message.setRecipients(MimeMessage.RecipientType.TO, "yurongchengs@163.com");
		
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("aaaa<img src='cid:mm'/>aaa", "text/html");
		
		MimeBodyPart imagePart = new MimeBodyPart();
		//�Ѵ����ϵ��ļ������ʼ�����������JAF���
		DataHandler dh = new DataHandler(new FileDataSource("D:/1.jpg"));
		//ͨ��JAF��ȡ�����ļ�������Ҫ����MIME���ͣ�JAF��ܻ��Զ�̽��
		imagePart.setDataHandler(dh);
		
		imagePart.setContentID("mm");							//����ID
		
		//�������ߵĹ�ϵ
		MimeMultipart mmpart = new MimeMultipart();
		mmpart.addBodyPart(textPart);
		mmpart.addBodyPart(imagePart);
		mmpart.setSubType("related");							//˵�����������й�ϵ��
		
		message.setContent(mmpart);
		message.saveChanges();
		message.writeTo(new FileOutputStream("D:/2.eml"));
	}
}
