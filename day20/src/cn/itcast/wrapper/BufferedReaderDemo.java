package cn.itcast.wrapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderDemo {
/*
	public static void main(String[] args) throws Exception {
		Reader in = new FileReader("src/cn/itcast/wrapper/BufferedReaderDemo.java");
		BufferedReader br = new BufferedReader(in);
		String str = null;
		while ((str = br.readLine())!=null){
			System.out.println(str);
		}
	}
*/
	public static void main(String[] args) throws Exception {
		Reader in = new FileReader("src/cn/itcast/wrapper/BufferedReaderDemo.java");
		BufferedReader br = new BufferedReader(in);
		MyBufferedReader mbr = new MyBufferedReader(br);
		String str = null;
		while ((str = mbr.readLine())!=null){
			System.out.println(str);
		}
	}
}
