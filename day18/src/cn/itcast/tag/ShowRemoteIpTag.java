package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
//TagSupport实现了Tag接口————标签处理器类
public class ShowRemoteIpTag extends TagSupport {
	
	public ShowRemoteIpTag(){
		System.out.println("执行了默认构造方法");
	}
	
	@Override
	public int doStartTag() throws JspException {
		String remoteIp = pageContext.getRequest().getRemoteAddr();
    	try {
			pageContext.getOut().write(remoteIp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
