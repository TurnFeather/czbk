package cn.itcast.stag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5Tag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		JspFragment jf = getJspBody();
		jf.invoke(sw);				//Executes the fragment and directs all output to the given Writer
		String str = sw.toString();	//取到了主体内容
		str = str.toUpperCase();
		getJspContext().getOut().write(str);
	}
	
}
