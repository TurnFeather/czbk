package cn.itcast.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Department;
import cn.itcast.domain.Employee;
import cn.itcast.util.DBCPUtil;
/**
 * 主表
 create table department(
 	id int primary key,
 	name varchar(100)
 );
 
 * 从表
 create table employee(
 	id int primary key,
 	name varchar(100),
 	salary float(8,2),
 	dept_id int,
 	constraint dept_id_fk foreign key(dept_id) references departmet(id)
 );
 */
public class DepartmentDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void addDepartment(Department d){
		if (d!=null){
			try {
				qr.update("insert into department (id,name) values(?,?)", d.getId(),d.getName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int size = d.getEmps().size();
			if (d.getEmps()!=null && size>0){
				Object [][]params = new Object[size][];
				for (int i=0;i<size;i++){
					Employee e = d.getEmps().get(i);
					params[i] = new Object[]{e.getId(),e.getName(),e.getSalary(),d.getId()};
				}
				try {
					qr.batch("insert into employee (id,name,salary,dept_id) values(?,?,?,?)", params);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public Department findDepartment(Integer id){
		//查询部门的基本信息
		Department d = null;
		try {
			d = qr.query("select * from department where id=?", new BeanHandler<Department>(Department.class), id);
		
			//部门关联的员工信息
			if (d!=null){
				d.setEmps(qr.query("select * from employee where dept_id=?", new BeanListHandler<Employee>(Employee.class), id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
