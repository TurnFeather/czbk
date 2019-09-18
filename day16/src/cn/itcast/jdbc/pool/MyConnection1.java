package cn.itcast.jdbc.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
/*
 * a����дһ���࣬����Ĭ�ϵ�������
 * b������һ�����ã���ס����д���ʾ��
 * c�����幹�췽�������뱻��д���ʾ��
 * d������Ҫ��д�ķ�������д����
 */
public class MyConnection1 extends ConnectionWrapper {
	private Connection conn;
	private LinkedList<Connection> pool;
	public MyConnection1(Connection conn,LinkedList<Connection> pool) {
		super(conn);
		this.conn = conn;
		this.pool = pool;
	}
	@Override
	public void close() throws SQLException {
		pool.add(conn);
	}
	
}
