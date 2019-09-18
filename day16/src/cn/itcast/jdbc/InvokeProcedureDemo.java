package cn.itcast.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import org.junit.Test;

import cn.itcast.util.JdbcUtil;

public class InvokeProcedureDemo {
	@Test
	public void test(){
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareCall("{call demoSp(?,?)}");
			//存储过程中输入参数，给值即可。输出参数，要告诉它参数类型
			stmt.setString(1, "to beijing");
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.execute();
			System.out.println(stmt.getString(2));
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
