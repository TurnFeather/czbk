package cn.itcast.listener;

public class StudentTest {

	public static void main(String[] args) {
		Student s = new Student("����");
		s.addStudentListener(new StudentListener(){
			public void preEat(StudentEvent e) {
				Student ss = (Student) e.getSource();
				System.out.println(ss.getName() + "������");
			}

			public void preStudy(StudentEvent e) {
				Student ss = (Student) e.getSource();
				System.out.println(ss.getName() + "�Ⱥ�һ��ţ��");
			}
			
		});
		
		s.eat();
		s.study();
	}

}
