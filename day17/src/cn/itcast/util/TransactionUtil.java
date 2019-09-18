package cn.itcast.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

//把得到连接及事务有关的方法写到此类中
public class TransactionUtil {
	private static ThreadLocal<Connection> tl = new ThreadLocal();
	private static DataSource ds;
	static{
		try {
			InputStream in = DBCPUtil.class.getClassLoader().getSystemResourceAsStream("dbcpconfig.properties");
			Properties props = new Properties();
			props.load(in);
			ds = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection(){
		try{
			Connection conn = tl.get();
			if (conn == null){
					conn = ds.getConnection();
					tl.set(conn);
				}
			return conn;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public static void startTransaction(){
		try{
			Connection conn = tl.get();
			if (conn == null){
					conn = getConnection();
				}
			conn.setAutoCommit(false);
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public static void rollback(){
		try{
			Connection conn = tl.get();
			if (conn == null){
					conn = getConnection();
				}
			conn.rollback();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public static void commit(){
		try{
			Connection conn = tl.get();
			if (conn == null){
					conn = getConnection();
				}
			conn.commit();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public static void release(){
		try{
			Connection conn = tl.get();
			if (conn != null)
			{
				conn.close();
				tl.remove();
			}
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
