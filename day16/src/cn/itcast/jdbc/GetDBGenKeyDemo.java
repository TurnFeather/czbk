package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.util.JdbcUtil;

/*
 create database day16;
 use day16;
 create table t1(
 	id int primary key auto_increment,
 	name varchar(100)
 );
 */

public class GetDBGenKeyDemo {
	@Test
	public void test(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("insert into t1(name) value(?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, "wxy");
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()){
				int id = rs.getInt(1);
				System.out.println(id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}	
}
