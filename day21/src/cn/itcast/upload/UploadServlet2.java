package cn.itcast.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//首先判断客户端表单请求中的entype类型是否是multipart/form-data
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(!isMultipart){
				System.out.println("二狗子");
				return;
			}
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);
			List<FileItem> items = sfu.parseRequest(request);
			for (FileItem item : items){
				//判断是否是普通字段
				if(item.isFormField()){
					String fieldName = item.getFieldName();
					String fieldValue = item.getString("UTF-8");
					System.out.println(fieldName + "=" + fieldValue);
				}else
				{
					//判断上传是否为图片
					if (item.getContentType().startsWith("image"))
					{
						//文件字段
						String fileName = item.getName();		//获得文件名
						fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
						fileName = UUID.randomUUID() + "_" + fileName;
						InputStream in = item.getInputStream();
						//获得要保存文件的绝对路径
						
						//得到文件的真实路径
						String realPath = getServletContext().getRealPath("/WEB-INF/files");	//D:\apache-tomcat-6.0.48\webapps\day21\WEB-INF\files
						//打散存储目录
						String newStorePath = makeStorePath(realPath,fileName);
						OutputStream out = new FileOutputStream(newStorePath + "\\" + fileName);
						System.out.println(fileName);
						System.out.println("realPath:" + realPath);
						byte b[] = new byte[1024];
						int length = -1;
						while((length=in.read(b))!=-1)
						{
							out.write(b, 0, length);
						}
					}
				}
			}
		} catch (FileUploadException e) {
			throw new RuntimeException("服务器忙");
		}
	}

	private String makeStorePath(String realPath, String fileName) {
		int hashCode = fileName.hashCode();
		int dir1 = hashCode&0xf;
		int dir2 = (hashCode&0xf0)>>4;
		
		File file = new File(realPath + "//" + dir1 + "//" + dir2);
		if (!file.exists())
			file.mkdirs();
		return realPath + "//" + dir1 + "//" + dir2;
	}

}
