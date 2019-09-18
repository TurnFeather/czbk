package cn.itcast.jdbc.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyDataSourceClient {
	private static DataSource ds = new MyDataSource();
	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = ds.getConnection();	//具体的类型跟接口无关，跟右边的有关
			//利用conn做一些操作
			System.out.println(conn);
			conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();		//实际上并没有关闭，放回连接池中去了
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
