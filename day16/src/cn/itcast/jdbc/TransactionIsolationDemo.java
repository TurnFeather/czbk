package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.util.JdbcUtil;

//演示事务的隔离级别
//隔离级别必须在事务之中
public class TransactionIsolationDemo {
	@Test
	public void test()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			conn.setTransactionIsolation(conn.TRANSACTION_READ_UNCOMMITTED);	//一定要在事务开启之前设置隔离级别，否则无效
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("select * from account where name='aaa'");
			rs = stmt.executeQuery();
			if (rs.next()){
				System.out.println("开始时的余额：" + rs.getInt("money"));
			}
			Thread.sleep(10*1000);
			stmt = conn.prepareStatement("select * from account where name='aaa'");
			rs = stmt.executeQuery();
			if (rs.next()){
				System.out.println("别人未提交事务时的余额：" + rs.getInt("money"));
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
