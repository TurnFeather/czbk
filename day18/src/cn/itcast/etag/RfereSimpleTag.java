package cn.itcast.etag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RfereSimpleTag extends SimpleTagSupport {
	private String site;
	private String adPage;
	
	public void setSite(String site) {
		this.site = site;
	}

	public void setAdPage(String adPage) {
		this.adPage = adPage;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext)getJspContext();
		HttpServletRequest rq = (HttpServletRequest)pageContext.getRequest();
		HttpServletResponse res = (HttpServletResponse)pageContext.getResponse();
		String referer = rq.getHeader("referer");
		if(referer!=null){
			//判断是否从允许站点处访问
			System.out.println(rq.getContextPath());
			System.out.println(referer);
			if(!referer.startsWith(site)){
				res.sendRedirect(rq.getContextPath() + "/example/ad.jsp");
			}
		}
		//res.sendRedirect(rq.getContextPath() + "");
	}
	
}
