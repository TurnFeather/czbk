package cn.itcast.base.Web;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception 
	{
		ServerSocket server = new ServerSocket(8888);
		while (true)
		{
			Socket socket = server.accept();
			//InputStream in = socket.getInputStream();		//用户的输入
			OutputStream out = socket.getOutputStream();	//给用户返回数据
			InputStream in = new FileInputStream("src/hello.html");
			int len = -1;
			byte b[] = new byte[1024];
			while ((len = in.read(b)) != -1)
			{
				out.write(b, 0, len);
			}
			socket.close();
			in.close();
		}
	}

}
