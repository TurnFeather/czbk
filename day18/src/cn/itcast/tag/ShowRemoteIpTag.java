package cn.itcast.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
//TagSupportʵ����Tag�ӿڡ���������ǩ��������
public class ShowRemoteIpTag extends TagSupport {
	
	public ShowRemoteIpTag(){
		System.out.println("ִ����Ĭ�Ϲ��췽��");
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
