package cn.itcast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class MailClient {

	public static void main(String[] args) throws Exception, IOException {
		Socket socket = new Socket("smtp.163.com",25);
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));	//接受服务器的反馈信息
		OutputStream out = socket.getOutputStream();						//向服务器发送信息
		out.write("ehlo wzt\r\n".getBytes());
		System.out.println("a:" + br.readLine());
		System.out.println("b:" + br.readLine());
		System.out.println("c:" + br.readLine());
		System.out.println("d:" + br.readLine());
		System.out.println("e:" + br.readLine());
		System.out.println("f:" + br.readLine());
		System.out.println("g:" + br.readLine());
		System.out.println("g:" + br.readLine());
		
		out.write("auth login\r\n".getBytes());
		System.out.println("h:" + br.readLine());
		out.write("aXRoZWltYTE0\r\n".getBytes());
		System.out.println("i:" + br.readLine());
		out.write("aWFtc29ycnk=\r\n".getBytes());
		System.out.println("j:" + br.readLine());
		out.write("mail from:<itheima14@163.com>\r\n".getBytes());
		System.out.println("k:" + br.readLine());
		out.write("rcpt to:<yurongchengs@163.com>\r\n".getBytes());
		System.out.println("l:" + br.readLine());
		out.write("data\r\n".getBytes());
		System.out.println("n:" + br.readLine());
		out.write("from:itheima14@163.com\r\n".getBytes());
		out.write("to:yurongchengs@163.com\r\n".getBytes());
		out.write("subject:haha\r\n".getBytes());
		out.write("\r\n".getBytes());
		out.write("Welcome to Beijing NCIST.\r\n".getBytes());
		out.write(".\r\n".getBytes());
		System.out.println("o:" + br.readLine());
		socket.close();
	}
}
