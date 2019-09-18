package cn.itcast.dbutil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import cn.itcast.domain.Account;
import cn.itcast.util.DBCPUtil;

public class DbUtilDemo2 {
	private QueryRunner qs = new QueryRunner(DBCPUtil.getDataSource());
	@Test
	public void test1() throws SQLException{
		Account account = qs.query("select * from account where id=?", new BeanHandler<Account>(Account.class),1);
		System.out.println(account);
	}
	
	@Test
	public void test2() throws SQLException{
		List<Account> list = qs.query("select * from account", new BeanListHandler<Account>(Account.class));
		
		for(Account account : list)
			System.out.println(account);
	}
	
	@Test//ArrayHandler：把结果集中的第一行数据转成对象数组。
	public void test3() throws SQLException{
		//Object os[] = qs.query("select * from account where id=?", 1, new ArrayHandler());
		Object os[] = qs.query("select * from account",  new ArrayHandler());
		for(Object o : os){
			System.out.println(o);
		}
			
	}
	
	@Test	//ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
	public void test4() throws SQLException{
		List<Object[]> list = qs.query("select * from account",  new ArrayListHandler());
		for (Object[] os : list){
			System.out.println("***********************");
			for(Object o : os){
				System.out.println(o);
			}
		}
	}
	
	@Test //ColumnListHandler：将结果集中某一列的数据存放到List中。
	public void test5() throws SQLException{
		List<Object> list = qs.query("select * from account",  new ColumnListHandler("name"));
		for (Object os : list){
			System.out.println(os);
		}
	}
	
	@Test //ColumnListHandler：将结果集中某一列的数据存放到List中。
	public void test6() throws SQLException{
		List<Object> list = qs.query("select * from account",  new ColumnListHandler("id"));
		for (Object os : list){
			System.out.println(os);
		}
	}
	
	@Test //KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map<列名,列值>里，再把这些map再存到一个map里，其key为指定的key。
	public void test7() throws SQLException{
		Map<Object,Map<String,Object>> map = qs.query("select * from account", new KeyedHandler(1));
		for(Map.Entry<Object, Map<String,Object>> maps : map.entrySet()){
			System.out.println(maps.getKey() + ":---------------------");
			for (Map.Entry<String, Object> me : maps.getValue().entrySet()){
				System.out.println(me.getKey() + ":" + me.getValue());
			}
		}
	}
	
	@Test //MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
	public void test8() throws SQLException{
		Map<String,Object> map = qs.query("select * from account where id=1", new MapHandler());
		for (Map.Entry<String, Object> me : map.entrySet()){
			System.out.println(me.getKey() + ":" + me.getValue());
		}
	}
	
	@Test //MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
	public void test9() throws SQLException{
		List<Map<String,Object>> list = qs.query("select * from account", new MapListHandler());
		for (Map<String,Object> map : list){
			for (Map.Entry<String, Object> me : map.entrySet()){
				System.out.println(me.getKey() + ":" + me.getValue());
			}
		}
	}
}
