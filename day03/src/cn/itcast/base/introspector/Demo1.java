package cn.itcast.base.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;
//��ʡ���������Եģ����е�getter��setter������
public class Demo1 {
	@Test
	public void test1() throws Exception
	{
		//�õ�Student���е�����,����װ��BeanInfo��
		BeanInfo info =  Introspector.getBeanInfo(Student.class);
		//�õ��������е�����������
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		System.out.println(pds.length);
		for (PropertyDescriptor pd : pds)
		{
			System.out.println(pd.getName());
		}
	}
	@Test
	public void test2() throws Exception
	{
		Student s = new Student();
		PropertyDescriptor pd = new PropertyDescriptor("name",Student.class);
		Method m = pd.getReadMethod();
		String value = (String)m.invoke(s, null);
		System.out.println(value);
		//�ı�name��ֵ
		Method m1 = pd.getWriteMethod();
		m1.invoke(s, "����");
		System.out.println(s.getName());
	}
	//����BeanUtils��ܲ�������
	@Test
	public void test3() throws Exception
	{
		Student s = new Student();
		//ΪʲôҪ�����ַ���:�û����������붼���ַ���
		String str = BeanUtils.getProperty(s, "name");		//�������ʵ���ϵ���getName��������
		System.out.println(str);
		//����ֵ
		BeanUtils.setProperty(s, "name", "�ż̿�");
		System.out.println(s.getName());
	}
	@Test//BeanUtils���Խ������͵��Զ�ת���������޻����Ķ�����������Ҫint�ͣ������ַ�����ok
	public void test4() throws Exception
	{
		Student s = new Student();
		//ΪʲôҪ�����ַ���:�û����������붼���ַ���
		String str = BeanUtils.getProperty(s, "age");		//�������ʵ���ϵ���getName��������
		System.out.println(str);
		//����ֵ
		BeanUtils.setProperty(s, "age", "19");
		System.out.println(s.getAge());
	}
	//�ǻ������͵����Ե�����
	//�û������붼��String
	//String <------>��������֮���ת��
	//�û������Ľ�������ַ���
	@Test
	public void test5() throws Exception
	{
		Student s = new Student();
		//��BeanUtilsע������ת����:�Զ���ת����
		ConvertUtils.register(new Converter(){
			//type:��Ŀ������
			//value����ǰ�����ֵ
			public Object convert(Class type, Object value) {
				/*
				if (type.equals(Date.class)){
					//�ַ���ת��ΪDate
				}else
				{
					//Dateת��Ϊ�ַ���
				}*/
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	//����/ʱ���ʽ�����ࣨ�� SimpleDateFormat��������и�ʽ����Ҳ�������� -> �ı�����
																	//�������ı�-> ���ڣ��ͱ�׼���������ڱ�ʾΪ Date ���󣬻��߱�ʾΪ�� GMT���������α�׼ʱ�䣩
																	//1970 �� 1 �� 1 �� 00:00:00 ��һ�̿�ʼ�ĺ�������
				if (value instanceof String)
				{
					//�ַ���תDate
					String v = (String)value;
					try {
						Date d = df.parse(v);
						return d;
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
					
				}else
				{
					//Dateת��Ϊ�ַ���
					Date d = (Date)value;
					return df.format(d);
				}
			}
			
		}, Date.class);
		BeanUtils.setProperty(s, "birthday", "1996-02-14");
		System.out.println(s.getBirthday());
	}
	@Test
	public void test51() throws Exception
	{
		Student s = new Student();
		//��BeanUtilsע������ת����:�Զ���ת����
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(s, "birthday", "1996-02-14");
		System.out.println(s.getBirthday());
	}
}
