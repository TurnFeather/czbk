package cn.itcast.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.domain.Student;
import cn.itcast.domain.Teacher;
import cn.itcast.util.DBCPUtil;

public class TeacherDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void addTeacher(Teacher t){
		//向teacher表中插入老师数据
		try {
			qr.update("insert into teacher (id,name,money) values(?,?,?)", t.getId(),t.getName(),t.getMoney());
			//判断老师对象t中是否有学生，该学生是否在数据库中已经存在，有，则插入，没有，不操作
			List<Student> stus = t.getStus();
			if (stus!=null&stus.size()>0){
				for (Student s : stus){
					//从student数据库表中查询学生是否存在
					Object obj = qr.query("select 1 from student where id=?", new ScalarHandler(1), s.getId());
					if (obj == null){	//该学生在数据库中不存在
						qr.update("insert into student (id,name,grade) values(?,?,?)", s.getId(),s.getName(),s.getGrade());
					}
					//在第三方表中建立老师和学生的关系
					qr.update("insert into teacher_student (t_id,s_id) values(?,?)", t.getId(),s.getId());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Teacher findTeacher(Integer id){
		try {
			//先从数据库查到老师，再查询老师所教的学生
			Teacher t = qr.query("select * from teacher where id=?",
					new BeanHandler<Teacher>(Teacher.class), id);
			if (t!=null){
				//String sql = "select * from student where id in (select s_id from teacher_student where t_id=?)";
				String sql = "select s.* from student s inner join teacher_student ts on ts.s_id=s.id and ts.s_id=?";
				List<Student> list =  qr.query(sql, new BeanListHandler<Student>(Student.class), id);
				t.setStus(list);
			}
			
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
