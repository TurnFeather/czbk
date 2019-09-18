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
	//@Autowired				//根据类型来匹配类型
	@Qualifier("student_annotation")					//根据配置文件的id来进行匹配
	private Student student;
	
	private Set set;
	private List list;
	private Map map;
	private Properties properties;
	public Student getStudent() {
		return student;
	}
}
