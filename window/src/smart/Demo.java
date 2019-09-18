package smart;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/*
 * 创建一个窗口用于显示服务器接收和发送的消息
 * 
 */
public class Demo 
{
	 JFrame jf;          //创建一个面板
	 JScrollPane jsb;
	 JTextArea jta;
	 JLabel jl ;
	//初始化窗口
	public Demo()
	{
		jf = new JFrame("任意窗");
		jta = new JTextArea(50,100);
		jsb = new JScrollPane(jta);
		jl = new JLabel("");
		jl.setHorizontalAlignment(JLabel.RIGHT);
		jf.setLayout(new BorderLayout());
		jf.add(jl,BorderLayout.NORTH);
		jf.add(jsb,BorderLayout.CENTER);
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
