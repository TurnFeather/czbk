package cn.itcast.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ����
 create table department(
 	id int primary key,
 	name varchar(100)
 );
 
 * �ӱ�
 create table employee(
 	id int primary key,
 	name varchar(100),
 	salary float(8,2),
 	dept_id int,
 	constraint dept_id_fk foreign key(dept_id) references departmet(id)
 );
 */

public class Department implements Serializable {
	private Integer id;		//��Ҫ�����ݿ����ɣ��������Լ�ά��
	private String name;
	private List<Employee> emps = new ArrayList<Employee>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
}