package smart;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * server
 * 服务器主类
 *
 */
public class Server 
{	
	//设置界面
	static Demo demo = new Demo();
	//定义一个静态端口号
	private static final int  PORT = 5655;
	//定义一个map集合存放窗户和手机的ID和输入流
	public static ClientMap<String,OutputStream> clients = new ClientMap<>();
	/******************************初始化服务器*********************************/
	@SuppressWarnings("resource")
	public void link()
	{
	try {
		//建一个服务器套接字监听端口
		ServerSocket server = new ServerSocket(PORT);
		demo.jta.append("服务器已启动，等待连接。。。\n");
		while(true)
		{
			Socket socket = server.accept();
			Client client = new Client(socket);
			demo.jta.append("有新用户连接了。。。\n");
			new Thread(new ReadThread(client),"读").start();
			new Thread(new WriterThread(client),"写").start();
		}
	} catch (IOException e) {
		demo.jta.append("服务器启动失败，请检查端口："+PORT+"是否被占用\n");
	}
		
	}
	//主线程，启动服务器
	public static void main(String[] args)
	{
		
		new Server().link();
	
}
}
