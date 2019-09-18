package smart;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
/**
 * 读取和处理数据类
 * 可变类
 * 每个用户对应一个实例
 */
public class Client 
{
	private int count=0;
	private BigDecimal time=new BigDecimal("0");//记录读取数据的时间
	private Socket socket;//连接客户端的套接字
	private InputStream r;//数据传输的输入流
	private OutputStream w;//数据传输的输出流
	private ArrayList<BigDecimal> buffer=new ArrayList<>();//存储数据的缓冲区
	private boolean flag = true;//判断缓存区是否有数据
	public Client(Socket socket)
	{
		this.socket=socket;
		try {
			r = socket.getInputStream();
			w = socket.getOutputStream();
			//连接数据库
			Class.forName("com.mysql.jdbc.Driver");		
		} catch (IOException e) {
			System.out.println("I/O打开失败！");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/******************************读取数据
	 * @throws SQLException *******************************/
	public synchronized void readMsg() throws SQLException 
	{
		try {	
					//建一个字节数据作为一次读取数据的缓冲区
					byte[] b = new byte[55];
					r.read(b);//将读取的数据存入缓冲区
					//记录数据条数
					count++;
					System.out.print("第"+count+"条数据");
					for(byte x:b)
					{
						System.out.format("-[%x]-", x);
						
					}
					System.out.println();
					byte sum=0;//用于计算校验码的值
					//累加，计算校验码
					for(int i=1;i<b.length-2;i++)
					{
						sum+=b[i];
					}
					//判断是否为窗户发来的信息	
					if((buffer.size()<54)&&(b[0]==TCP_ID.HEAD)&&(b[1]==TCP_ID.WINDOW_LENGTH)&&(b[53]==sum)&&(b[54]==TCP_ID.END))
					{
						//将该客户添加到集合中以便于管理
						BigDecimal name = new BigDecimal(b[2]*10000+b[3]*100+b[4]);
						//如果集合中没有同名用户，将该用户添加到map集合中
						if(!Server.clients.map.containsKey(name.toString()))
						{
							Server.clients.put(name.toString(),w);
							Server.demo.jl.setText("当前在线:"+Server.clients.map.size());
						}
						//将用户名添加到集合中
						buffer.add(new BigDecimal(new Date().getTime()));
						buffer.add(name);
						//将有效信息转换为BigDecimal后添加到buffer中
						for(int i=5;i<b.length-2;i=i+3)
						{
							switch(b[i])
							{
							//空调开关
								case 0x30:{
								buffer.add(new BigDecimal(b[i+2]));
								break;
							}
								//窗户幅度信息
								case 0x31:{
									//若发送过来的两个有效字节都为0xff则记为-1
								if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
								else //否则将数据处理后转换为BigDecimal后存入缓冲区
									{
										double fl = b[i+1]+b[i+2]/100.0;
										buffer.add(BigDecimal.valueOf(fl));
									}
										break;
							}
								//工作模式
								case 0x32:{
										buffer.add(new BigDecimal(b[i+2]));
										break;
										}
								//内连接状态
								case 0x33:{
										buffer.add(new BigDecimal(b[i+2]));
										break;
										}
								//外连接状态
								case 0x34:{
										buffer.add(new BigDecimal(b[i+2]));
										break;
										}
								//控制连接状态
								case 0x35:{
										buffer.add(new BigDecimal(b[i+2]));
										break;
										}
								//红外接收器
								case 0x40:{
										buffer.add(new BigDecimal(b[i+2]));
										break;
										}
								//PM2.5
								case 0x41:{
										if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
										else 
											{
												System.out.print("2.5="+b[i+1]+" "+b[i+2]+"\n");
												double fl =  ((b[i+1]&0xff)*256+b[i+2]&0xff);
												buffer.add(BigDecimal.valueOf(fl));
											}
											break;
										}
								//PM10
								case 0x42:{
										if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
										else 
											{
												System.out.print("10="+b[i+1]+" "+b[i+2]+"\n");
												double fl = ((b[i+1]&0xff)*256+b[i+2]&0xff);
												buffer.add(BigDecimal.valueOf(fl));
											}
											break;
										}
								//风力
								case 0x43:{
										if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
										else 
										{
											double fl = (double) (b[i+1]+b[i+2]/100.0);
											buffer.add(BigDecimal.valueOf(fl));
										}
											break;
										}
								//外部温度
								case 0x44:{
										if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
										else 
										{
											double fl = (double) (b[i+1]+b[i+2]/100.0);
											buffer.add(BigDecimal.valueOf(fl));
										}
											break;
										}
								//外部湿度
								case 0x45:{
										if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
										else 
										{
											double fl = (double) (b[i+1]+b[i+2]/100.0);
											buffer.add(BigDecimal.valueOf(fl));
										}
											break;
										}
								//内部温度
								case 0x50:{
										if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
										else 
										{
											double fl = (double) (b[i+1]+b[i+2]/100.0);
											buffer.add(BigDecimal.valueOf(fl));
										}
											break;
										}
								//内部湿度
								case 0x51:{
									if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
									else 
										{
											double fl = (double) (b[i+1]+b[i+2]/100.0);
											buffer.add(BigDecimal.valueOf(fl));
										}
											break;
										}
								//烟雾指数
								case 0x52:{
										if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
										else 
										{
											double fl = (double) (b[i+1]+b[i+2]/100.0);
											buffer.add(BigDecimal.valueOf(fl));
										}
											break;
										}
								//声音指数
								case 0x53:{
										if((b[i+1]==0xff)&&(b[i+2]==0xff)) buffer.add(new BigDecimal("-1"));
										else 
										{
											double fl = (double) (b[i+1]+b[i+2]/100.0);
											buffer.add(BigDecimal.valueOf(fl));
										}
											break;
										}
							}
						}
						//每次读完一次数据就唤醒写数据线程
						wait(100);
						notifyAll();
					}						
					else if((b[0]==TCP_ID.HEAD)&&(b[1]==TCP_ID.APP_LENGTH)/*&&(b[7]==sum)*/&&(b[9]==TCP_ID.END))
					{
						//将读到的消息发送给窗户
						byte[] c = new byte[7];//存放发往窗户的数据
						b[1]-=3;//更改数据长度值
						//将有效数据存进数组c中
						for(int i=0;i<7;i++)
						{	
							c[i]=b[i];
							if(i>1)c[i]=b[i+3];
						}
						System.out.println();
						byte sum2=0;
						for(int i=1;i<c.length-2;i++)
						{
							sum2+=c[i];
						}
						
						c[5]=sum2;
						for(byte x:c)System.out.print(x+"\t");//验证数组内数据
						senMsg(c);
						
						//每次读完一次数据就唤醒写数据线程
						wait(100);
						notifyAll();
					}
					else 
					{
						wait();
						notifyAll();
					}
		}catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
		}catch (IOException e) {
					setFlag(false);//设置旗标为假结束线程
		if(Server.clients.map.containsValue(w))
		{
			//连接断开后将数据表中的信息初始化
			try(	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/window","root","root");
					PreparedStatement pre_status = con.prepareStatement("update status set client=0,30H=0,32H=0,33H=0,34H=0,35H=0,40H=0,62H=0"))//更新数据表信息
					{
						pre_status.executeUpdate();
						System.out.println("---------------------------------------");
					}	
						Server.clients.removeByValue(w);
						Server.demo.jl.setText("当前在线:"+Server.clients.map.size());			
		}	
		try {
				//关闭输入流
				if(r!=null)
				{
					r.close();
				}
				//关闭输出流
				if(w!=null)
				{
					w.close();
				}
				//关闭套接字
				if(socket!=null)
				{
					socket.close();
				}
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}			
		} 	 
}
	/**************************写入数据******************************/
	public synchronized void writeMsg()
	{
		ArrayList<BigDecimal> status = new ArrayList<>();//临时存放连接状态数据
		ArrayList<BigDecimal> info = new ArrayList<>();//临时存放传感器数据
		try 
		{
			if(buffer.isEmpty())
			{
				wait();
				notifyAll();
			}
			else
			{
					//缓冲区数据已满     
					if((buffer.size()>36))
					{
							//分三次向临时空间存放数据，并写入数据库
							for(int i=0;i<3;i++)
							{
								if(buffer.get(i*18).compareTo(time)>0)
								{
									for(int j=0;j<16;j++)
									{
										if(j<6)
										{
											status.add(buffer.get(i*18+2+j));
										}
										else info.add(buffer.get(i*18+2+j));
									}
									setStatus(status,buffer.get(i*18+1).toString());
							  		setInformation(info,buffer.get(i*18+1).toString());
									writerToDemo(status,info,buffer.get(i*18+1).toString());
									status.clear();//清空临时空间
									info.clear();//清空临时空间
									this.time=buffer.get(i*18);//将时间设置为最后一次缓冲区中的时间
									wait(100);
									notifyAll();
								}	
							}
							//缓冲区已满数据都是重复的则清空缓冲区
							buffer.clear();
					}
					//缓冲区有2组数据
					 if((buffer.size()>18)&&(buffer.size()<=36))
					{
						
							for(int i=0;i<2;i++)
							{
								if(buffer.get(i*18).compareTo(time)>0)
								{
									for(int j=0;j<16;j++)
									{
										if(j<6)//将数据分离开，后期数据需要写到两个表中
										{
											status.add(buffer.get(i*18+2+j));
										}
										else info.add( buffer.get(i*18+2+j));
									}
									setStatus(status,buffer.get(i*18+1).toString());
							  		setInformation(info,buffer.get(i*18+1).toString());
									writerToDemo(status,info,buffer.get(i*18+1).toString());
									status.clear();//清空临时空间
									info.clear();//清空临时空间
									wait(100);
									notifyAll();
									this.time=buffer.get(i*18);//将时间设置为最后一次缓冲区中的时间
								}
						}
					}
						//缓冲区有一组数据
					  if((buffer.size()>0)&&(buffer.size()<=18))
					{
						  if(buffer.get(0).compareTo(time)>0)
						  {
							  for(int j=0;j<16;j++)
							  {
								  if(j<6)
								  {
									  status.add (buffer.get(j+2));
								  }
								  else info.add(buffer.get(j+2));
							  }
							 		setStatus(status,buffer.get(1).toString());
							  		setInformation(info,buffer.get(1).toString());
							  		writerToDemo(status,info,buffer.get(1).toString());
							  		status.clear();//清空临时空间
							  		info.clear();//清空临时空间
							  		this.time=buffer.get(0);//将时间设置为最后一次缓冲区中的时间
							  		wait(100);
							  		notifyAll();
						  }	
					}	
			}	
		} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	}
	/****************************发送数据 ******************************/
	public void senMsg(byte[]instruct) throws IOException
	{
		
			for(OutputStream os:Server.clients.valueSet())
			{
				if(Server.clients.getKeyByValue(os).startsWith("33"))
				{
					os.write(instruct);
				}
			}
		
	}
	/***************************判断socket是否已断*******************************/
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	/*****************************向数据库写入数据********************************/
	//将数据写入表示连接状态的数据表
	private void setStatus(ArrayList<BigDecimal> status,String ID) throws SQLException
	{
		try(	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/window","root","root");
				PreparedStatement pre_status = con.prepareStatement("update status set client=?,30H=?,32H=?,33H=?,34H=?,35H=?,40H=?,62H=?"))//更新数据表信息
				{
					//写入ID
					pre_status.setString(1, ID);
					//写入连接状态的表示数据
					for(int i=1;i<=6;i++)
					{
						pre_status.setInt(i+1,(status.get(i-1)).intValue());
					}
						pre_status.setInt(8,1);
					pre_status.executeUpdate();
				}
	}
	//将数据写入表示传感器数据的数据表
	private void setInformation(ArrayList<BigDecimal> info,String ID) throws SQLException
	{
		try(	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/window","root","root");
				PreparedStatement pre_info = con.prepareStatement("insert into information values(?,?,?,?,?,?,?,?,?,?,?,?,null)"))//向数据库写入连接状态        
				{
					//写入ID
					pre_info.setString(1, ID);
					//写入各个传感器的数据
					for(int i=1;i<=10;i++)
					{
						pre_info.setFloat(i+1,(info.get(i-1)).floatValue());
					}
					//写入时间
					pre_info.setObject(12,new Date());
					
					pre_info.executeUpdate();
				}	
	}
	/*****************************窗口打印********************************/
	public void writerToDemo(ArrayList<BigDecimal> status,ArrayList<BigDecimal> info,String ID)
	{
		//向窗口打印各部位连接状态
		Server.demo.jta.append(MyTime.getTime()+":"+"\n"+"连接状态:"+ID+"--");
		for(BigDecimal big:status)
		{
			Server.demo.jta.append(big+"  ");
		}
		Server.demo.jta.append("\n");
		//向窗口打印各个传感器数据
		Server.demo.jta.append("数据："+ID+"--");
		for(BigDecimal b:info)
		{
			Server.demo.jta.append(b+"  ");
		}
		Server.demo.jta.append("\n");
		Server.demo.jta.setCaretPosition(Server.demo.jta.getDocument().getLength());
	}
	/*****************************重写hashCode方法********************************/
	public int hashCode()
	{
		return socket.hashCode();
	}
	/******************************重写equals方法********************************/
	public boolean equals(Object obj)
	{
		if(this==obj)
		{
			return true;
		}
		if(obj!=null&&obj.getClass()==Client.class)
		{
			Client target=(Client)obj;
			return target.w.equals(w);
		}
		return false;
	}
}
