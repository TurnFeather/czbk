package cn.itcast.etag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfSimpleTag extends SimpleTagSupport {
	boolean test = false;
	
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if(test==true){
			//��ȡ��������Ƭ��
			JspFragment jf = getJspBody();
			jf.invoke(null);
		}else{
			//����ʲô������
		}
	}
	
}
