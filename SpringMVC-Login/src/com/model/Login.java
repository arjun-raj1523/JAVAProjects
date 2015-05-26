package com.model;

public class Login {
	String username,password;
	
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

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
