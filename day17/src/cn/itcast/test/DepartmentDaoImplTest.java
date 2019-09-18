package cn.itcast.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.itcast.dao.impl.DepartmentDaoImpl;
import cn.itcast.domain.Department;
import cn.itcast.domain.Employee;

public class DepartmentDaoImplTest {
	private DepartmentDaoImpl dao = new DepartmentDaoImpl();
	@Test
	public void testAddDepartment() {
		Department d = new Department();
		d.setId(1);
		d.setName("kfb");
		
		Employee eq1 = new Employee();
		eq1.setId(1);
		eq1.setName("zsf");
		eq1.setSalary(5000);
		eq1.setDept(d);			//������ϵ
		Employee eq2 = new Employee();
		eq2.setId(2);
		eq2.setName("yrc");
		eq2.setSalary(8000);
		eq2.setDept(d);			//������ϵ
		
		d.getEmps().add(eq1);	//������ϵ
		d.getEmps().add(eq2);	//������ϵ
		//�����ݿ��в����µĲ��Ų���
		dao.addDepartment(d);
	}

	@Test
	public void testFindDepartment() {
		Department d = dao.findDepartment(1);
		System.out.println(d.getName());
		List<Employee> emps = d.getEmps();
		for (Employee e : emps){
			System.out.println(e.getName());
		}
	}

}
