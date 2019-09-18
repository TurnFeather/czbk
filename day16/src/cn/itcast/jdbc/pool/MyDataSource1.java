package cn.itcast.jdbc.pool;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

import javax.sql.DataSource;

import cn.itcast.util.JdbcUtil;
//一个标准的数据源
public class MyDataSource1 implements DataSource {
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
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		
		return 0;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		if (pool.size() > 0){
			final Connection conn = pool.remove();
			return (Connection)Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					if("close".equals(method.getName())){
						return pool.add(conn);
					}else{
						return method.invoke(conn, args);
					}
				}
			});
		}else{
			throw new RuntimeException("服务器真忙");
		}
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
