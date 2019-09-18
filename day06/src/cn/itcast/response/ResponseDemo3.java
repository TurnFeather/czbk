package cn.itcast.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//输出随机验证码图片
public class ResponseDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 90;
		int height = 24;
		//创建一幅内存图像：BufferedImage
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//得到属于该图片的画笔：Graphics
		Graphics g = img.getGraphics();
			//画边框
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width, height);
			//填充背景色
		g.setColor(Color.YELLOW);
		g.fillRect(1, 1, width-2, height-2);
			//画干扰线
		g.setColor(Color.GRAY);
		Random r = new Random();
		for (int i = 0;i<10;i++)
		{
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
			//随机数字
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD | Font.ITALIC,30));
		for (int i=0;i<4;i++)
		{
			//g.drawString(r.nextInt(10)+"", 15+i*10, 15);
			g.drawString(r.nextInt(10)+"", 0 + i * 22, 24);
		}
		
		//输出到浏览器的页面上
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
