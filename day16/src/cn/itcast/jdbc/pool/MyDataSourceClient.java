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
			conn = ds.getConnection();	//��������͸��ӿ��޹أ����ұߵ��й�
			//����conn��һЩ����
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
					conn.close();		//ʵ���ϲ�û�йرգ��Ż����ӳ���ȥ��
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
