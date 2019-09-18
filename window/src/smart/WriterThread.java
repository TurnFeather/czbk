package smart;

import java.net.Socket;

public class WriterThread implements Runnable
{
	private Client client;
	public WriterThread(Client client)
	{
		this.client=client;
	}
	public void run()
	{
		while(client.isFlag())
		{
			client.writeMsg();
		}
		
	}
}
