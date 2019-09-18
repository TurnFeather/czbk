package cn.itcast.annotation.scan;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("scan_Person")
public class Scan_Person {
	@Resource(name="scan_Student")
	private Scan_Student student;
	public Scan_Student getStudent() {
		return student;
	}
}
