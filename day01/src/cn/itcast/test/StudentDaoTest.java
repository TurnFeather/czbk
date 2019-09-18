package cn.itcast.test;

import cn.itcast.dao.StudentDao;

public class StudentDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDao();
		/*
		 * Student s = new Student(); s.setIdcard("555"); s.setExamid("666");
		 * s.setName("余荣城"); s.setLocation("四川"); s.setGrade(100);
		 * 
		 * dao.createStudent(s);
		 */
		/*
		 * Student s = dao.findStudent("666"); System.out.println(s);
		 */
		boolean b = dao.deleteStudent("李四");
		System.out.println(b);
	}

}
