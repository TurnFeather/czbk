package cn.itcast.etag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HtmlFilterSimpleTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		PageContext pg = (PageContext)getJspContext();
		getJspBody().invoke(sw);
		String s = sw.toString();		//Return the buffer's current value as a string
		s = filter(s);
		pg.getOut().write(s);
	}
	private String filter(String message) {
        if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());

    }
}
