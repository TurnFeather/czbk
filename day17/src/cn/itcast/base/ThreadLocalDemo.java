package cn.itcast.base;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal();		//内部有一个Map：key，当前线程对象；value是你自己放入的东西
		tl.set("pp");
		new OtherThread(tl).start();
		Object obj = tl.get();
		System.out.println(obj);
	}
}
