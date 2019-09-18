package cn.itcast.jdbc.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
/*
 * a、编写一个类，集成默认的适配器
 * b、定义一个引用，记住被改写类的示例
 * c、定义构造方法，传入被改写类的示例
 * d、对于要改写的方法，改写即可
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
