package cn.itcast.proxy;

public class Chun implements Human {

	@Override
	public void sing(float money) {
		System.out.println("�õ�Ǯ��" + money + "����");
	}

	@Override
	public void dance(float money) {
		System.out.println("�õ�Ǯ��" + money + "����");
	}

}
