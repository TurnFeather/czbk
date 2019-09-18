package cn.itcast.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
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
			Class.forName(className);		//¼ÓÔØÇý¶¯
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception
	{
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void release(ResultSet rs,Statement st,Connection conn)
	{
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
