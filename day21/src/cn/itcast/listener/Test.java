package cn.itcast.listener;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		for (String s : list){
			if (s.equals("ccc")){
				list.remove(s);
			}
		}
	}

}
