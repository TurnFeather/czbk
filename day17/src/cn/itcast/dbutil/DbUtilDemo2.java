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
	
	@Test//ArrayHandler���ѽ�����еĵ�һ������ת�ɶ������顣
	public void test3() throws SQLException{
		//Object os[] = qs.query("select * from account where id=?", 1, new ArrayHandler());
		Object os[] = qs.query("select * from account",  new ArrayHandler());
		for(Object o : os){
			System.out.println(o);
		}
			
	}
	
	@Test	//ArrayListHandler���ѽ�����е�ÿһ�����ݶ�ת��һ�����飬�ٴ�ŵ�List�С�
	public void test4() throws SQLException{
		List<Object[]> list = qs.query("select * from account",  new ArrayListHandler());
		for (Object[] os : list){
			System.out.println("***********************");
			for(Object o : os){
				System.out.println(o);
			}
		}
	}
	
	@Test //ColumnListHandler�����������ĳһ�е����ݴ�ŵ�List�С�
	public void test5() throws SQLException{
		List<Object> list = qs.query("select * from account",  new ColumnListHandler("name"));
		for (Object os : list){
			System.out.println(os);
		}
	}
	
	@Test //ColumnListHandler�����������ĳһ�е����ݴ�ŵ�List�С�
	public void test6() throws SQLException{
		List<Object> list = qs.query("select * from account",  new ColumnListHandler("id"));
		for (Object os : list){
			System.out.println(os);
		}
	}
	
	@Test //KeyedHandler(name)����������е�ÿһ�����ݶ���װ��һ��Map<����,��ֵ>��ٰ���Щmap�ٴ浽һ��map���keyΪָ����key��
	public void test7() throws SQLException{
		Map<Object,Map<String,Object>> map = qs.query("select * from account", new KeyedHandler(1));
		for(Map.Entry<Object, Map<String,Object>> maps : map.entrySet()){
			System.out.println(maps.getKey() + ":---------------------");
			for (Map.Entry<String, Object> me : maps.getValue().entrySet()){
				System.out.println(me.getKey() + ":" + me.getValue());
			}
		}
	}
	
	@Test //MapHandler����������еĵ�һ�����ݷ�װ��һ��Map�key��������value���Ƕ�Ӧ��ֵ��
	public void test8() throws SQLException{
		Map<String,Object> map = qs.query("select * from account where id=1", new MapHandler());
		for (Map.Entry<String, Object> me : map.entrySet()){
			System.out.println(me.getKey() + ":" + me.getValue());
		}
	}
	
	@Test //MapListHandler����������е�ÿһ�����ݶ���װ��һ��Map�Ȼ���ٴ�ŵ�List
	public void test9() throws SQLException{
		List<Map<String,Object>> list = qs.query("select * from account", new MapListHandler());
		for (Map<String,Object> map : list){
			for (Map.Entry<String, Object> me : map.entrySet()){
				System.out.println(me.getKey() + ":" + me.getValue());
			}
		}
	}
}
