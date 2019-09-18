package cn.itcast.dbassist;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import cn.itcast.dbassist.exception.DBAssistException;
import cn.itcast.dbassist.handler.ResultSetHandler;

//框架的核心类
public class DBAssist {
	private DataSource ds;
	public DBAssist(DataSource ds){
		this.ds = ds;
	}
	/**
	 * 完成DML语句：记录的添加、删除、修改
	 */
	public void update(String sql,Object[] params){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = ds.getConnection();		//得到连接
			stmt = conn.prepareStatement(sql);
			//设置参数
			ParameterMetaData pmd = stmt.getParameterMetaData();
			int count = pmd.getParameterCount();	//得到SQL语句中的占位符顺序
			if(count > 0){
				//有参数
				if (params==null||params.length<1)
					throw new IllegalArgumentException("The parameter is wrong");
				if(params.length!=count)
					throw new IllegalArgumentException("The parameter count is wrong");
				//参数个数匹配
				for(int i=0;i<count;i++){
					stmt.setObject(i+1, params[i]);
				}
			}
			stmt.executeUpdate();
		}catch(Exception e){
			throw new DBAssistException(e);
		}finally{
			//释放资源
			release(rs, stmt, conn);
		}
	}
	
	public Object query(String sql,Object[] params,ResultSetHandler rsh){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = ds.getConnection();		//得到连接
			stmt = conn.prepareStatement(sql);
			
			//设置参数
			ParameterMetaData pmd = stmt.getParameterMetaData();
			int count = pmd.getParameterCount();	//得到SQL语句中的占位符顺序
			if(count > 0){
				//有参数
				if (params==null||params.length<1)
					throw new IllegalArgumentException("The parameter is wrong");
				if(params.length!=count)
					throw new IllegalArgumentException("The parameter count is wrong");
				//参数个数匹配
				
				for(int i=0;i<count;i++){
					stmt.setObject(i+1, params[i]);
				}
				
			}
			rs = stmt.executeQuery();
			//目的：封装到对象中去。现在有结果集
			return rsh.handler(rs);
		}catch(Exception e){
			throw new DBAssistException(e);
		}finally{
			//释放资源
			release(rs, stmt, conn);
		}
	}
	
	//自己调用
	private static void release(ResultSet rs,Statement stmt,Connection conn){
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
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
