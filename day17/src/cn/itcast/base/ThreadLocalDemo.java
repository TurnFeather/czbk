package cn.itcast.base;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal();		//�ڲ���һ��Map��key����ǰ�̶߳���value�����Լ�����Ķ���
		tl.set("pp");
		new OtherThread(tl).start();
		Object obj = tl.get();
		System.out.println(obj);
	}
}
