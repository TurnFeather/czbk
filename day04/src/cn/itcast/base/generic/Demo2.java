package cn.itcast.base.generic;

//���������������ͣ�ֻ��ʵ��������Ч,��ʵ��������ֱ���þ��У����ǲ��ʺϾ�̬������
public class Demo2<T> {
	public void m1(T t)
	{
		
	}
	public T m2(T t)
	{
		return null;
	}
	public static <T> T m3(T t)		//�ھ�̬������ʹ�õķ����������뵥������
	{
		return t;
	}
}
