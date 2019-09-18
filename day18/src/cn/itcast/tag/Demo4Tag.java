package cn.itcast.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
//使用一次标签，对应实例化的变量长驻内存中
public class Demo4Tag extends TagSupport {
	private int count = 3;
	//在调用doStartTag之前，容器会把属性的值自动传进来
	public void setCount(int count) {
		this.count = count;
		System.out.println("嗯很");
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
