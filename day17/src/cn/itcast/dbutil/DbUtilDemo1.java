package cn.itcast.dbutil;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itcast.util.DBCPUtil;

public class DbUtilDemo1 {
	private QueryRunner runner = new QueryRunner(DBCPUtil.getDataSource());
	/*
	create database day17;
	create table t1(
	id int primary key,
	name varchar(20),
	birthday date
	);
	 */
	@Test
	public void testAdd() {
		try {
			runner.update("insert into t1 (id,name,birthday) values(?,?,?)", 1,"yrc",new Date());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAdd2() {
		try {
			runner.update("insert into t1 (id,name,birthday) values(?,?,?)", 2,"yrc","2014-03-22");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testupdate() {
		try {
			runner.update("update t1 set name=? where id=?", "zhangsanfneg",1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testdelete() {
		try {
			runner.update("delete from t1 where name=?", "zhangsanfneg");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testBeatch() {
		try {
			Object params[][] = new Object[10][];
			for (int i=0;i<10;i++){
				params[i] = new Object[]{i+1,"yrc"+(i+1),new Date()};
			}
			runner.batch("insert into t1 (id,name,birthday) values(?,?,?)", params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 create table t2(
	 id int primary key,
	 content longtext
	 );
	 */
	//不建议使用
	@Test
	public void testClob() {
		try {
			File file = new File("src/abc.txt");
			Reader r = new FileReader("src/abc.txt");
			char ch[] = new char[(int)file.length()];
			r.read(ch);
			r.close();
			Clob clob = new SerialClob(ch);
			runner.update("insert into t2 (id,content) values(?,?)", 1,clob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 create table t3(
	 id int primary key,
	 content longblob
	 );
	 */
	@Test
	public void testBlob() {
		try {
			InputStream r = new FileInputStream("src/aaa.jpg");
			byte b[] = new byte[r.available()];
			r.read(b);
			r.close();
			Blob blob = new SerialBlob(b);
			runner.update("insert into t3 (id,content) values(?,?)", 1,blob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
