package cn.itcast.etag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEach2SimpleTag extends SimpleTagSupport {
	private Object items;
	private String var;
	private Collection collection;
	public void setItems(Object items) {
		if (items instanceof List){
			collection = (List)items;
		}else if(items instanceof Set){
			collection = (Set)items;
		}else if(items instanceof Map){
			collection = ((Map)items).entrySet();
		}else if(items.getClass().isArray()){
			collection = new ArrayList();
			int len = Array.getLength(items);
			for (int i=0;i<len;i++){
				collection.add(Array.get(items, i));
			}
			
		}else{
			throw new RuntimeException("对不起，不支持该类型的迭代操作");
		}
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pg = (PageContext)getJspContext();
		
		for (Object o : collection){
			pg.setAttribute(var, o);
			getJspBody().invoke(null);
		}
	}
	
}
