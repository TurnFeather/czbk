package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.util.JdbcUtil;

public class JdbcCRUD {
	@Test
	public void add()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
		
	}
	@Test
	public void update()
	{
		
	}
	@Test
	public void queryOne()
	{
		
	}
	@Test
	public void queryAll()
	{
		
	}
	@Test
	public void delete()
	{
		
	}
}
