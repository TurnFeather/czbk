package cn.itcast.jdbc.pool;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Properties;

import cn.itcast.util.JdbcUtil;
//����ʹ��������ʱ���Ĭ�Ͽ�ʼ����10��Connection��������
//���ݿ����ӳص�ԭ��
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
			Class.forName(className);		//��������
		
			//��ʼ����ʱ�������з���10������
			for (int i=0;i<10;i++){
				Connection conn = DriverManager.getConnection(url, user, password);
				pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//�������
	public synchronized static Connection getConnection()
	{
		if (pool.size() > 0){
			Connection conn = pool.remove();//remove() ��ȡ���Ƴ����б��ͷ����һ��Ԫ�أ���
			return conn;
		}else{
			System.out.println("��������ĺ�æ��");
			return null;
		}
	}
	//�Ż�����
	public static void release(Connection conn){
		pool.add(conn);
	}
}
