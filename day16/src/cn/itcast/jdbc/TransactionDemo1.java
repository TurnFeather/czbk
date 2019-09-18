package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import cn.itcast.util.JdbcUtil;
//通过aaa给bbb转账练习事务的基本使用
public class TransactionDemo1 {
	@Test
	public void test1()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//事务默认是自动开启的
			conn = JdbcUtil.getConnection();
			//手动开启事务
			conn.setAutoCommit(false);	//事务的开始：相当于start transaction
			stmt = conn.prepareStatement("update account set money = money - 100 where name='aaa'");
			System.out.println(stmt.executeUpdate());
			//int i = 1/0;
			stmt = conn.prepareStatement("update account set money = money + 100 where name='bbb'");
			System.out.println(stmt.executeUpdate());
			conn.commit();	//提交事务：commit
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
	@Test
	public void test2()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Savepoint sp = null;
		try{
			//事务默认是自动开启的
			conn = JdbcUtil.getConnection();
			//手动开启事务
			conn.setAutoCommit(false);	//事务的开始：相当于start transaction
			stmt = conn.prepareStatement("update account set money = money - 100 where name='aaa'");
			stmt.executeUpdate();
			stmt = conn.prepareStatement("update account set money = money + 100 where name='bbb'");
			stmt.executeUpdate();
			sp = conn.setSavepoint();		//设置回滚点
			//int i = 1/0;
			stmt = conn.prepareStatement("update account set money = money - 100 where name='bbb'");
			stmt.executeUpdate();
			stmt = conn.prepareStatement("update account set money = money + 100 where name='ccc'");
			stmt.executeUpdate();
			conn.commit();	//提交事务：commit
		}catch(Exception e){
			try {
				conn.rollback(sp);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			JdbcUtil.release(rs, stmt, conn);
		}
}
