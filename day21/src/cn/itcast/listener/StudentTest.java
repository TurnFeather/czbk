package cn.itcast.listener;

public class StudentTest {

	public static void main(String[] args) {
		Student s = new Student("ÕÅÈı");
		s.addStudentListener(new StudentListener(){
			public void preEat(StudentEvent e) {
				Student ss = (Student) e.getSource();
				System.out.println(ss.getName() + "ÂıÂı³Ô");
			}

			public void preStudy(StudentEvent e) {
				Student ss = (Student) e.getSource();
				System.out.println(ss.getName() + "ÏÈºÈÒ»±­Å£ÄÌ");
			}
			
		});
		
		s.eat();
		s.study();
	}

}
