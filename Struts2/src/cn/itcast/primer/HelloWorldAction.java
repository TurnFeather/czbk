package cn.itcast.primer;

import com.opensymphony.xwork2.ActionSupport;


//public class HelloWorldAction implements Action {
public class HelloWorldAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		System.out.println("Hello World Action ****** excute");
		return "success";
	}

}
