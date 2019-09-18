package cn.itcast.listener;

public class Student {
	private String name;
	private StudentListener listener;
	
	public Student(String name){	//ע�룬ͨ�����췽��ע��
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void eat(){
		if (listener!=null){
			listener.preEat(new StudentEvent(this));
		}
		System.out.println("��ʼ��");
	}
	
	public void study(){
		if (listener!=null){
			listener.preStudy(new StudentEvent(this));
		}
		System.out.println("��ʼѧ");
	}
	//ע�����
	public void addStudentListener(StudentListener listener){
		this.listener = listener;
	}
}
