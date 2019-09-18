package cn.itcast.action;

public class HelloWorldAction implements Action {

	public String execute() {
		System.out.println("HelloWorldAction****************execute()");
		return "success";
	}

}
