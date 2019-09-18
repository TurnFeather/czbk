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
		Properties props = new Properties();//环境变量设置。发送邮件时才需要
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);//代表一封邮件
		
		message.setFrom(new InternetAddress("itheimacloud@163.com"));//设置发件人
		message.setRecipients(Message.RecipientType.TO, "itheima14@163.com");//设置收件人
		message.setSubject("这是一封文本中内嵌图片的邮件");//设置主题
		
		//文本部分
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("美女bbb<img src='cid:mm'/>bbb", "text/html;charset=UTF-8");
		//内嵌图片部分
		MimeBodyPart imagePart = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("E:/1.jpg"));
		imagePart.setDataHandler(dh);
		imagePart.setContentID("mm");
		//文本和内嵌图片合体
		
		MimeMultipart mpart1 = new MimeMultipart();
		mpart1.addBodyPart(textPart);
		mpart1.addBodyPart(imagePart);
		mpart1.setSubType("related");
		
		MimeBodyPart textImagePart = new MimeBodyPart();
		textImagePart.setContent(mpart1);
		
		//附件部分
		MimeBodyPart attachmentPart = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("E:/附件.7z"));
		String filename = dh.getName();//获取文件名
		System.out.println(filename);
		attachmentPart.setDataHandler(dh);
		attachmentPart.setFileName(MimeUtility.encodeText(filename));//手工设置文件名.中文文件名要注意编码
		
		
		//全部合体
		MimeMultipart mpart2 = new MimeMultipart();
		mpart2.addBodyPart(textImagePart);//文本加内嵌图片
		mpart2.addBodyPart(attachmentPart);//附件
		mpart2.setSubType("mixed");//复杂关系
		
		message.setContent(mpart2);
		message.saveChanges();
		
		message.writeTo(new FileOutputStream("E:/3.eml"));
		
	}

}
