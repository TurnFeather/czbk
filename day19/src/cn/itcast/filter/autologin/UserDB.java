package cn.itcast.filter.autologin;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
	private static List<User> users = new ArrayList<User>();
	static{
		users.add(new User("gfy","¸ö·şÒÛ","123"));
		users.add(new User("zql","ÖìÇÉÁá","123"));
		users.add(new User("ÍøÏéÔÆ","ÏéÔÆ¸ç","123"));
	}
	
	public static User findUser(String username,String password){
		User user = null;
		for (User u : users){
			if (username.equals(u.getUsername())&&password.equals(u.getPassword())){
				user = u;
				break;
			}
		}
		return user;
	}
	
	//TODO
	public static User findUser(String username){
		User user = null;
		for (User u : users){
			if (username.equals(u.getUsername())){
				user = u;
				break;
			}
		}
		return user;
	}
}
