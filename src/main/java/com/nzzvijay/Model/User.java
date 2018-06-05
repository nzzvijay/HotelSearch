package com.nzzvijay.Model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class User {

	@Id
	String username;
	String name;
	String gender;
	String age;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public User(String username, String name, String gender, String age) {
		super();
		this.username = username;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}
