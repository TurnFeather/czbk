package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo2Tag extends TagSupport {
	//SKIP_BODY�����Ա�ǩ����������
	//EVAL_BODY_INCLUDE�������Ա�ǩ����������
	@Override//��ʼ��ǩʱ����
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return Tag.SKIP_BODY;
	}

}
