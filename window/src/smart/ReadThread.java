package smart;

import java.net.Socket;
import java.sql.SQLException;

public class ReadThread implements Runnable
{
	private Client client;
	public ReadThread(Client client)
	{
		this.client=client;
	}
	public void run()
	{
		while(client.isFlag())
		{
				try {
					client.readMsg();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					//e.printStackTrace();
					System.out.println("用户下线");
				}
		}
		
	}
}
