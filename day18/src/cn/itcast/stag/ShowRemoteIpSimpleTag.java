package cn.itcast.stag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowRemoteIpSimpleTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		PageContext page = (PageContext)getJspContext();
		String ip = page.getRequest().getRemoteAddr();
		page.getOut().write(ip);
		super.doTag();
	}
	
}
