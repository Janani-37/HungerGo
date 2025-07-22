package com.tap.model;

import java.sql.Timestamp;

public class User {
	
	private int userID;
	private String name;
	private String username;
	private String password;
	private String email;
	private String phone_number;
	private String address;
	private String role;
	private Timestamp create_date;
	private Timestamp last_login_date;
	
	
	public User() {
		
	}


	public User(int userID, String name, String username, String password, String email, String phone_number,
			String address, String role, Timestamp create_date, Timestamp last_login_date) {
		super();
		this.userID = userID;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.role = role;
		this.create_date = create_date;
		this.last_login_date = last_login_date;
	}


	public int getUserID() {
		return userID;
	}


	public String getName() {
		return name;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public String getEmail() {
		return email;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public String getAddress() {
		return address;
	}


	public String getRole() {
		return role;
	}


	public Timestamp getCreate_date() {
		return create_date;
	}


	public Timestamp getLast_login_date() {
		return last_login_date;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}


	public void setLast_login_date(Timestamp last_login_date) {
		this.last_login_date = last_login_date;
	}


	public User(String name, String username, String password, String email, String phone_number, String address,
			String role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.role = role;
	}


	@Override
	public String toString() {
		return "User: ["+name+" "+email+" "+phone_number+" ]";
	}


	public User(int userID, String name, String username, String password, String email, String phone_number,
			String address, String role) {
		super();
		this.userID = userID;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.role = role;
	}
	
	
	

}
