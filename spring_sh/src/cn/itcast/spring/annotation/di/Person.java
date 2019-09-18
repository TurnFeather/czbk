package cn.itcast.spring.annotation.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	private Long pid;
	private String pname;
	//@Resource(name="student_annotation")
	//@Autowired				//����������ƥ������
	@Qualifier("student_annotation")					//���������ļ���id������ƥ��
	private Student student;
	
	private Set set;
	private List list;
	private Map map;
	private Properties properties;
	public Student getStudent() {
		return student;
	}
}
