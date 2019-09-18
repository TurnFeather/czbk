import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailDemo3 {

	public static void main(String[] args) throws Exception{
		Properties props = new Properties();//�����������á������ʼ�ʱ����Ҫ
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);//����һ���ʼ�
		
		message.setFrom(new InternetAddress("itheimacloud@163.com"));//���÷�����
		message.setRecipients(Message.RecipientType.TO, "itheima14@163.com");//�����ռ���
		message.setSubject("����һ���ı�����ǶͼƬ���ʼ�");//��������
		
		//�ı�����
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("��Ůbbb<img src='cid:mm'/>bbb", "text/html;charset=UTF-8");
		//��ǶͼƬ����
		MimeBodyPart imagePart = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("E:/1.jpg"));
		imagePart.setDataHandler(dh);
		imagePart.setContentID("mm");
		//�ı�����ǶͼƬ����
		
		MimeMultipart mpart1 = new MimeMultipart();
		mpart1.addBodyPart(textPart);
		mpart1.addBodyPart(imagePart);
		mpart1.setSubType("related");
		
		MimeBodyPart textImagePart = new MimeBodyPart();
		textImagePart.setContent(mpart1);
		
		//��������
		MimeBodyPart attachmentPart = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("E:/����.7z"));
		String filename = dh.getName();//��ȡ�ļ���
		System.out.println(filename);
		attachmentPart.setDataHandler(dh);
		attachmentPart.setFileName(MimeUtility.encodeText(filename));//�ֹ������ļ���.�����ļ���Ҫע�����
		
		
		//ȫ������
		MimeMultipart mpart2 = new MimeMultipart();
		mpart2.addBodyPart(textImagePart);//�ı�����ǶͼƬ
		mpart2.addBodyPart(attachmentPart);//����
		mpart2.setSubType("mixed");//���ӹ�ϵ
		
		message.setContent(mpart2);
		message.saveChanges();
		
		message.writeTo(new FileOutputStream("E:/3.eml"));
		
	}

}
