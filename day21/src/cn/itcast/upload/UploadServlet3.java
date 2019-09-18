package cn.itcast.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter pw = response.getWriter();
				try {
					//�����жϿͻ��˱������е�entype�����Ƿ���multipart/form-data
					boolean isMultipart = ServletFileUpload.isMultipartContent(request);
					if(!isMultipart){
						System.out.println("������");
						return;
					}
					//���û���
					DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
					File file = new File(getServletContext().getRealPath("/temp"));
					fileItemFactory.setRepository(file);			//������ʱ�ļ��洢Ŀ¼
					ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);
					
					//�����ļ��ϴ��ļ�����
					sfu.setProgressListener(new ProgressListener(){

						public void update(long pBytesRead,
								long pContentLength, int pItems) {
							System.out.println("�ܴ�С:" + pContentLength + "\t���ϴ�:" + pBytesRead + "\t�ڼ���:" + pItems);
						}
					});
					
					//���õ����ļ��Ĵ�С���ƣ������˴�С�Ѻ�����
					//sfu.setFileSizeMax(1024*1024*4);
					//�������ļ��Ĵ�С���ƣ������˴�С�Ѻ�����
					//sfu.setSizeMax(1024*1024*6);
					
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items){
						//�ж��Ƿ�����ͨ�ֶ�
						if(item.isFormField()){
							String fieldName = item.getFieldName();
							String fieldValue = item.getString("UTF-8");
							System.out.println(fieldName + "=" + fieldValue);
						}else
						{
							//�ж��ϴ��Ƿ�ΪͼƬ
							//if (item.getContentType().startsWith("image"))
							//{
								//�ļ��ֶ�
								String fileName = item.getName();		//����ļ���
								System.out.println("1��" + fileName);
								fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
								System.out.println("2��" + fileName);
								if(fileName==null || "".equals(fileName.trim()))
									continue;
								
								fileName = UUID.randomUUID() + "_" + fileName;
								InputStream in = item.getInputStream();
								
								//���Ҫ�����ļ��ľ���·��
								
								//�õ��ļ�����ʵ·��
								String realPath = getServletContext().getRealPath("/WEB-INF/files");	//D:\apache-tomcat-6.0.48\webapps\day21\WEB-INF\files
								//��ɢ�洢Ŀ¼
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
								in.close();
								out.close();
								item.delete();		//ɾ����ʱĿ¼�Ĵ洢�ļ�
							//}
						}
					}
				} catch (FileUploadException e) {
					throw new RuntimeException("������æ");
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
