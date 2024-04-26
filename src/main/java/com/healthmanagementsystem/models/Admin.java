package com.healthmanagementsystem.models;

public class Admin extends Person {
	private String username;
	private String adminId;
	private String password;

	@Override
	public String toString() {
		return "Admin [username=" + username + ", adminId=" + adminId + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
