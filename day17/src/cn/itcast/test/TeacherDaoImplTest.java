package cn.itcast.test;

import org.junit.Test;

import cn.itcast.dao.impl.TeacherDaoImpl;
import cn.itcast.domain.Student;
import cn.itcast.domain.Teacher;

public class TeacherDaoImplTest {
	TeacherDaoImpl dao = new TeacherDaoImpl();
	@Test
	public void testAddTeacher() {
		Teacher t1 = new Teacher();
		t1.setId(1);
		t1.setName("bxd");
		t1.setMoney(20000);
		
		Teacher t2 = new Teacher();
		t2.setId(2);
		t2.setName("wzt");
		t2.setMoney(15000);
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("gfy");
		s1.setGrade("A");
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("wxy");
		s2.setGrade("A");
		
		t1.getStus().add(s1);
		t1.getStus().add(s2);
		
		t2.getStus().add(s1);
		t2.getStus().add(s2);
		
		dao.addTeacher(t1);
		dao.addTeacher(t2);
	}
	@Test
	public void testQueryTeacher() {
		Teacher t = dao.findTeacher(2);
		System.out.println(t.getName());
		for(Student s : t.getStus()){
			System.out.println(s.getName());
		}
	}
}
