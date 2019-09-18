package cn.itcast.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllFilesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String> map = new HashMap<String,String>();	//key:真是文件名字 value:用户存储的文件名
		
		//获取存储文件的路径
		String storePath = getServletContext().getRealPath("/WEB-INF/files");
		File file = new File(storePath);
		//递归遍历所有文件，封装到Map中，然后转到JSP页面去显示
		treeWalk(file,map);
		for (Entry<String,String> item : map.entrySet()){
			System.out.println(item.getKey() + "=" + item.getValue());
		}
		request.setAttribute("resource", map);
		getServletContext().getRequestDispatcher("/show.jsp").forward(request, response);
	}

	private void treeWalk(File file, Map<String, String> map) {
		if (file.isDirectory()){
			//如果是目录，得到目录中所有的文件，再次遍历
			String items[] = file.list();
			for (String item : items){
				treeWalk(new File(file.getAbsolutePath()+"/" + item),map);
			}
		}else if(file.isFile()){
			map.put(file.getName(), file.getName().substring(file.getName().indexOf("_")+1));	//key:真是文件名字 value:用户存储的文件名
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
