package cn.itcast.dbassist.handler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import cn.itcast.dbassist.exception.DBAssistException;
//ǰ�᣺JavaBean�е��ֶ������ݿ���е��ֶ�һ��
//�ô�����ֻ�ʺϽ������ֻ��һ����¼�����
public class BeanHandler implements ResultSetHandler {
	private Class clazz;
	
	public BeanHandler(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object handler(ResultSet rs) {
		try {
			Object bean = clazz.newInstance();	//Ŀ��javabeanʵ��
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
