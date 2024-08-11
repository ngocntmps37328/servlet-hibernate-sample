package com.org.asm2.model;

public class UserSession {

	private String userName;

	private String role;

	public UserSession() {
		super();
	}

	public UserSession(String userName, String role) {
		super();
		this.userName = userName;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserSession [userName=" + userName + ", role=" + role + "]";
	}

}
