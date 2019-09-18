package cn.itcast.dbassist.handler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import cn.itcast.dbassist.exception.DBAssistException;
//前提：JavaBean中的字段与数据库表中的字段一致
//该处理器只适合结果集中只有一条记录的情况
public class BeanHandler implements ResultSetHandler {
	private Class clazz;
	
	public BeanHandler(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object handler(ResultSet rs) {
		try {
			Object bean = clazz.newInstance();	//目标javabean实例
			if(rs.next()){
				ResultSetMetaData rsmd = rs.getMetaData();
				int count = rsmd.getColumnCount();
				for(int i=0;i<count;i++){
					String colmnName = rsmd.getColumnName(i+1);
					Object columnValue = rs.getObject(i+1);
					Field f = clazz.getDeclaredField(colmnName);
					f.setAccessible(true);
					f.set(bean, columnValue);
				}
				System.out.println("aaaa");
				return bean;
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new DBAssistException(e);
		}
	}

}
