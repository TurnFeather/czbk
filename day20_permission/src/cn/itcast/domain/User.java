package cn.itcast.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	private String id;	//UUID
	private String username;
	private String password;
	private String nick;
	private List<Role> rolse = new ArrayList<Role>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public List<Role> getRolse() {
		return rolse;
	}
	public void setRolse(List<Role> rolse) {
		this.rolse = rolse;
	}
}
