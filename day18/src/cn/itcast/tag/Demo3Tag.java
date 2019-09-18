package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
//忽略结束标签后面的jsp内容
public class Demo3Tag extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		
		return Tag.SKIP_PAGE;
	}

}	
