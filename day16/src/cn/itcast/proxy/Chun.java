package cn.itcast.proxy;

public class Chun implements Human {

	@Override
	public void sing(float money) {
		System.out.println("拿到钱：" + money + "开唱");
	}

	@Override
	public void dance(float money) {
		System.out.println("拿到钱：" + money + "开跳");
	}

}
