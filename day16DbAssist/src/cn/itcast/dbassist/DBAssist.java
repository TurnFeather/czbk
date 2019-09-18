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

//��ܵĺ�����
public class DBAssist {
	private DataSource ds;
	public DBAssist(DataSource ds){
		this.ds = ds;
	}
	/**
	 * ���DML��䣺��¼����ӡ�ɾ�����޸�
	 */
	public void update(String sql,Object[] params){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = ds.getConnection();		//�õ�����
			stmt = conn.prepareStatement(sql);
			//���ò���
			ParameterMetaData pmd = stmt.getParameterMetaData();
			int count = pmd.getParameterCount();	//�õ�SQL����е�ռλ��˳��
			if(count > 0){
				//�в���
				if (params==null||params.length<1)
					throw new IllegalArgumentException("The parameter is wrong");
				if(params.length!=count)
					throw new IllegalArgumentException("The parameter count is wrong");
				//��������ƥ��
				for(int i=0;i<count;i++){
					stmt.setObject(i+1, params[i]);
				}
			}
			stmt.executeUpdate();
		}catch(Exception e){
			throw new DBAssistException(e);
		}finally{
			//�ͷ���Դ
			release(rs, stmt, conn);
		}
	}
	
	public Object query(String sql,Object[] params,ResultSetHandler rsh){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = ds.getConnection();		//�õ�����
			stmt = conn.prepareStatement(sql);
			
			//���ò���
			ParameterMetaData pmd = stmt.getParameterMetaData();
			int count = pmd.getParameterCount();	//�õ�SQL����е�ռλ��˳��
			if(count > 0){
				//�в���
				if (params==null||params.length<1)
					throw new IllegalArgumentException("The parameter is wrong");
				if(params.length!=count)
					throw new IllegalArgumentException("The parameter count is wrong");
				//��������ƥ��
				
				for(int i=0;i<count;i++){
					stmt.setObject(i+1, params[i]);
				}
				
			}
			rs = stmt.executeQuery();
			//Ŀ�ģ���װ��������ȥ�������н����
			return rsh.handler(rs);
		}catch(Exception e){
			throw new DBAssistException(e);
		}finally{
			//�ͷ���Դ
			release(rs, stmt, conn);
		}
	}
	
	//�Լ�����
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
