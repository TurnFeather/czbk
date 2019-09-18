package com.itheima.domain;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
	private static List<User> users = new ArrayList<User>();
	
	static{
		users.add(new User("niuyang","438"));
		users.add(new User("shanjie","123"));
	}
	
	public static User findUser(String username,String password)
	{
		User user = null;
		for (User u : users)
		{
			if (username.equals(u.getUsername()) && password.equals(u.getPassword()))
			{
				user = u;
				break;
			}
		}
		return user;
	}
}
