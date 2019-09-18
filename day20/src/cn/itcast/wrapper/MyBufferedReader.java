package cn.itcast.wrapper;

import java.io.BufferedReader;
import java.io.IOException;
/*
public class MyBufferedReader extends BufferedReader {
	private BufferedReader br;
	private int count = 0;
	public MyBufferedReader(BufferedReader br){
		super(br);
		this.br = br;
	}
	
	@Override
	public String readLine() throws IOException {
		String s;
		s = br.readLine();
		if (s==null)
			return s;
		return (++count) + "   " + s;
	}
	
}*/

public class MyBufferedReader extends BufferedReader {
	private int count = 0;
	public MyBufferedReader(BufferedReader br){
		super(br);
	}
	
	@Override
	public String readLine() throws IOException {
		String s;
		s = super.readLine();
		if (s==null)
			return s;
		return (++count) + "   " + s;
	}
	
}
