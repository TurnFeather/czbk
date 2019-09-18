package cn.itcast.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import cn.itcast.dao.impl.AccountDaoImpl;
import cn.itcast.domain.Account;
import cn.itcast.util.DBCPUtil;
import cn.itcast.util.TransactionUtil;

public class AccountServiceImpl {
	AccountDaoImpl dao = new AccountDaoImpl();
	public void transfer(String sourceAccountName,String targetAccountName,float money){
		try{
			TransactionUtil.startTransaction();
			Account sAccount = dao.findAccount(sourceAccountName);
			Account tAccount = dao.findAccount(targetAccountName);
			sAccount.setMoney(sAccount.getMoney() - money);
			tAccount.setMoney(tAccount.getMoney() + money);
			dao.update(sAccount);
			dao.update(tAccount);
		}catch(Exception e){
			try {
				TransactionUtil.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				TransactionUtil.commit();
				TransactionUtil.release();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
