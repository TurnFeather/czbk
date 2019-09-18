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
		Map<String,String> map = new HashMap<String,String>();	//key:�����ļ����� value:�û��洢���ļ���
		
		//��ȡ�洢�ļ���·��
		String storePath = getServletContext().getRealPath("/WEB-INF/files");
		File file = new File(storePath);
		//�ݹ���������ļ�����װ��Map�У�Ȼ��ת��JSPҳ��ȥ��ʾ
		treeWalk(file,map);
		for (Entry<String,String> item : map.entrySet()){
			System.out.println(item.getKey() + "=" + item.getValue());
		}
		request.setAttribute("resource", map);
		getServletContext().getRequestDispatcher("/show.jsp").forward(request, response);
	}

	private void treeWalk(File file, Map<String, String> map) {
		if (file.isDirectory()){
			//�����Ŀ¼���õ�Ŀ¼�����е��ļ����ٴα���
			String items[] = file.list();
			for (String item : items){
				treeWalk(new File(file.getAbsolutePath()+"/" + item),map);
			}
		}else if(file.isFile()){
			map.put(file.getName(), file.getName().substring(file.getName().indexOf("_")+1));	//key:�����ļ����� value:�û��洢���ļ���
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
