package cn.itcast.test;

import cn.itcast.service.impl.AccountServiceImpl;

public class Client {
	public static void main(String[] args){
		AccountServiceImpl service = new AccountServiceImpl();
		service.transfer("bbb", "aaa", 100);
	}
}
