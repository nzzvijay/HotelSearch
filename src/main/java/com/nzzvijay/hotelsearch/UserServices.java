package com.nzzvijay.hotelsearch;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nzzvijay.Model.User;

@Service
public class UserServices {

	@Autowired
	UserRepository userservices;
	
	@Autowired
	UserCommentServices commentservices;
	
	public void adduser(User user) {
		userservices.save(user);
	}
	
	public User finduser(String username) {
		return userservices.findByUsername(username);
	}
	
	public ArrayList<User> findUser(){
		return (ArrayList<User>) userservices.findAll();
	}

	public UserServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User findOneUser(String username) {
		// TODO Auto-generated method stub
		return userservices.findByUsername(username);
	}

	public void deleteuser(String id) {
		commentservices.deletecomment(id);
		userservices.deleteById(id);
		
	}
	
	
}
