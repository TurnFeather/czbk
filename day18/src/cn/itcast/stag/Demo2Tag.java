package cn.itcast.stag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo2Tag extends SimpleTagSupport {
	//�÷���ʲô����������ô�������ݾͲ���ʾ
	@Override
	public void doTag() throws JspException, IOException {
		/*
		JspFragment jf =  this.getJspBody();
		PageContext pg = (PageContext)this.getJspContext();
		jf.invoke(pg.getOut());
		*/
		JspFragment jf =  this.getJspBody();
		jf.invoke(null);		//�������Ϊnull����ôĬ�Ͼ��ǽ������е�����������������
	}
	
}
