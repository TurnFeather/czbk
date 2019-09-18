package cn.itcast.upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		String  username = request.getParameter("username");		//表单里没有“username”这个名字时返回null
		String f1 = request.getParameter("f1");
		System.out.println(username);
		System.out.println(f1);*/
		ServletInputStream in =  request.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = null;
		while((str = br.readLine())!=null){
			System.out.println(str);
		}

	}

}
