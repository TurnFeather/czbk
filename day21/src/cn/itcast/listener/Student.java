package cn.itcast.listener;

public class Student {
	private String name;
	private StudentListener listener;
	
	public Student(String name){	//注入，通过构造方法注入
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void eat(){
		if (listener!=null){
			listener.preEat(new StudentEvent(this));
		}
		System.out.println("开始吃");
	}
	
	public void study(){
		if (listener!=null){
			listener.preStudy(new StudentEvent(this));
		}
		System.out.println("开始学");
	}
	//注册监听
	public void addStudentListener(StudentListener listener){
		this.listener = listener;
	}
}
