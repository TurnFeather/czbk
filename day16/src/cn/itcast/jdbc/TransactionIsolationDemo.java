package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.util.JdbcUtil;

//��ʾ����ĸ��뼶��
//���뼶�����������֮��
public class TransactionIsolationDemo {
	@Test
	public void test()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			conn.setTransactionIsolation(conn.TRANSACTION_READ_UNCOMMITTED);	//һ��Ҫ��������֮ǰ���ø��뼶�𣬷�����Ч
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("select * from account where name='aaa'");
			rs = stmt.executeQuery();
			if (rs.next()){
				System.out.println("��ʼʱ����" + rs.getInt("money"));
			}
			Thread.sleep(10*1000);
			stmt = conn.prepareStatement("select * from account where name='aaa'");
			rs = stmt.executeQuery();
			if (rs.next()){
				System.out.println("����δ�ύ����ʱ����" + rs.getInt("money"));
			}
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
}
