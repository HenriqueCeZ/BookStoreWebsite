package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;	//JPA specification
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity //specifying that this class is mapped to the table in the DB


public class Users { //User is reserved word in my SQL

	private Integer userId;
	private String email;
	private String fullName;
	private String password;

	//these fields are mapped to the columns table in DB
	
	
	@Column(name = "user_id")
	@Id	//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "full_name")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
