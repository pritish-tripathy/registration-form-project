package com.model;

public class User {
	String username;
	String password;
	String gender;
	String phone;
	String email;
	public User(String username, String password, String gender, String phone, String email) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
	}
	public String getUserName() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
}
