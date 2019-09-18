package cn.itcast.action;

public class UserAction implements Action {

	public String execute() {
		System.out.println("UserAction****************execute()");
		return "success";
	}

}
