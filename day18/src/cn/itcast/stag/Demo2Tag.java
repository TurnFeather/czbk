package cn.itcast.stag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo2Tag extends SimpleTagSupport {
	//该方法什么都不做，那么主体内容就不显示
	@Override
	public void doTag() throws JspException, IOException {
		/*
		JspFragment jf =  this.getJspBody();
		PageContext pg = (PageContext)this.getJspContext();
		jf.invoke(pg.getOut());
		*/
		JspFragment jf =  this.getJspBody();
		jf.invoke(null);		//如果参数为null，那么默认就是将主体中的内容输出的浏览器端
	}
	
}
