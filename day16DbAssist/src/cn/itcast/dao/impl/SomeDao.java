package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import cn.itcast.dbassist.DBAssist;
import cn.itcast.dbassist.handler.BeanHandler;
import cn.itcast.domain.Account;
import cn.itcast.util.DBCPUtil;

public class SomeDao {
	private DBAssist da = new DBAssist(DBCPUtil.getDataSource());
	@Test
	public void add(){
		da.update("insert into account (name,money) values(?,?)", new Object[]{"ddd",5555});
	}
	@Test
	public void update(){
		da.update("update account set name=?,money=? where id=?", new Object[]{"dddd",20000,4});
	}
	@Test
	public void del(){
		da.update("delete from account where name=?", new Object[]{"dddd"});
	}
	@Test
	public void findOne(){
		Account account = (Account)da.query("select * from account where id=?", new Object[]{1},new BeanHandler(Account.class));
		System.out.println(account);
		//return account;
	}
}
