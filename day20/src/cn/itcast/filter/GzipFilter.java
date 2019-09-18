package cn.itcast.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GzipFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		GzipHttpServletResponse gresp = new GzipHttpServletResponse(resp);
		
		chain.doFilter(req, gresp);
		
		byte b[] = gresp.getOldBytes();
		System.out.println("原始数据大小：" + b.length);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(baos);
		gout.write(b);
		gout.finish();
		b = baos.toByteArray();
		System.out.println("压缩后数据大小：" + b.length);
		resp.setHeader("Content-Encoding", "gzip");
		resp.setContentLength(b.length);
		resp.getOutputStream().write(b);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
}

class GzipHttpServletResponse extends HttpServletResponseWrapper{
	private ByteArrayOutputStream baos = new ByteArrayOutputStream();	//把结果都输出到这个缓冲区来
	private PrintWriter pw = null;
	public GzipHttpServletResponse(HttpServletResponse response) {
		super(response);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException { 
		return new MyServletOutputStream(baos);
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		pw = new PrintWriter(new OutputStreamWriter(baos,super.getCharacterEncoding()));
		return pw;
	}

	public byte[] getOldBytes(){
		try {
			if (pw!=null){
				pw.close();
			}
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baos.toByteArray();
	}
}

class MyServletOutputStream extends ServletOutputStream{
	private ByteArrayOutputStream baos;
	public MyServletOutputStream(ByteArrayOutputStream baos){
		this.baos = baos;
	}
	@Override
	public void write(int b) throws IOException {
		baos.write(b);
	}
	
}
