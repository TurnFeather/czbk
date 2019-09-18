package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
//ʹ��һ�α�ǩ����Ӧʵ�����ı�����פ�ڴ���
public class Demo4Tag extends TagSupport {
	private int count = 3;
	//�ڵ���doStartTag֮ǰ������������Ե�ֵ�Զ�������
	public void setCount(int count) {
		this.count = count;
		System.out.println("�ź�");
	}

	@Override
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;           
	}
	
	@Override
	public int doAfterBody() throws JspException {
		count--;
		System.out.println(count);
		if (count > 0)
			return IterationTag.EVAL_BODY_AGAIN;
		else{
			count = 3;
			return Tag.SKIP_BODY;
		}
	}
}
