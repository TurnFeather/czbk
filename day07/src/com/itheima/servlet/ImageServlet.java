package com.itheima.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		int width = 90;
		int height = 24;
		//����һ���ڴ�ͼ��BufferedImage
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//�õ����ڸ�ͼƬ�Ļ��ʣ�Graphics
		Graphics g = img.getGraphics();
			//���߿�
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width, height);
			//��䱳��ɫ
		g.setColor(Color.YELLOW);
		g.fillRect(1, 1, width-2, height-2);
			//��������
		g.setColor(Color.GRAY);
		Random r = new Random();
		for (int i = 0;i<10;i++)
		{
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
			//�������
		g.setColor(Color.RED);
		g.setFont(new Font("����",Font.BOLD | Font.ITALIC,30));
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<4;i++)
		{
			int num = r.nextInt(10);
			sb.append(num);
			g.drawString(num+"", 0 + i * 22, 24);
			
		}
		
		String code = sb.toString();
		request.getSession().setAttribute("code", code);
		
		//������������ҳ����
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
