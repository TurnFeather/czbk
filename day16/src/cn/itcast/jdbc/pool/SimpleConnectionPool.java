package cn.itcast.jdbc.pool;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Properties;

import cn.itcast.util.JdbcUtil;
//当我使用这个类的时候就默认开始加载10个Connection对象连接
//数据库连接池的原理
public class SimpleConnectionPool {
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	private static String className = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	static{
		try {
			InputStream in = JdbcUtil.class.getClassLoader()
					.getResourceAsStream("dbinfo.properties");
			Properties props = new Properties();
			props.load(in);
			className = props.getProperty("className");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			Class.forName(className);		//加载驱动
		
			//初始化的时候将链表中放入10个连接
			for (int i=0;i<10;i++){
				Connection conn = DriverManager.getConnection(url, user, password);
				pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获得连接
	public synchronized static Connection getConnection()
	{
		if (pool.size() > 0){
			Connection conn = pool.remove();//remove() 获取并移除此列表的头（第一个元素）。
			return conn;
		}else{
			System.out.println("服务器真的很忙了");
			return null;
		}
	}
	//放回连接
	public static void release(Connection conn){
		pool.add(conn);
	}
}
