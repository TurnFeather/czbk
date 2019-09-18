package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import cn.itcast.util.C3P0Util;
import cn.itcast.util.DBCPUtil;

public class DaoDemo {
	@Test
	public void add(){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = C3P0Util.getConnection();
			System.out.println(conn.getClass().getName());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBCPUtil.release(null, stmt, conn);
		}
	}
}
