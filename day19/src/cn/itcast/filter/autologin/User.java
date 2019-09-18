package cn.itcast.filter.autologin;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String nick;
	private String password;
	User(){
		
	}
	
	public User(String username, String nick, String password) {
		super();
		this.username = username;
		this.nick = nick;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
