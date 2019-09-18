package cn.itcast.base;

public class OtherThread extends Thread {
	private ThreadLocal tl;
	public OtherThread(ThreadLocal tl){
		this.tl = tl;
	}
	@Override
	public void run() {
		System.out.println("另一个线程中的东西：" + tl.get());
	}
	
}
