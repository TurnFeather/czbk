package cn.itcast.annotation.scan;

import org.springframework.stereotype.Component;

@Component("scan_Student")
public class Scan_Student {
	public void sayHello()
	{
		System.out.println("Hello,��Һã�����ѧ��");
	}
}
