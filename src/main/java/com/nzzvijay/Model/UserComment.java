package com.nzzvijay.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
public class UserComment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String Comments;
	float rating;
	
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	User user;
	
	
	
	public UserComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserComment(String comments,float rating, User user) {
		super();
		Comments = comments;
		this.rating=rating;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
