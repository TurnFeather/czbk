package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.domain.Account;
import cn.itcast.util.TransactionUtil;

public class AccountDaoImpl {
	private QueryRunner qr = new QueryRunner();
	public Account findAccount(String username){
		try {
			return qr.query(TransactionUtil.getConnection(), "select * from account where name=?", new BeanHandler<Account>(Account.class), username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Account account){
		try {
			qr.update(TransactionUtil.getConnection(), "update account set money=? where name=?", account.getMoney(),account.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
