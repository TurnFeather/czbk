package cn.itcast.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	public static Connection getConnection(){
		try {
			return cpds.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
