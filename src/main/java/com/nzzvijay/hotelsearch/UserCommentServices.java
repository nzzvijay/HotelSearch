package com.nzzvijay.hotelsearch;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nzzvijay.Model.UserComment;

@Service
public class UserCommentServices {
	
	@Autowired
	Usercommentrepo usercommentrepo;
	

	public void addcomment(Collection<UserComment> usercomment) {
		usercommentrepo.saveAll(usercomment);
	}
	
	public void addcomment(UserComment usercomment) {
		usercommentrepo.save(usercomment);
	}
	
	public ArrayList<UserComment> getcomment() {
		
		return (ArrayList<UserComment>) usercommentrepo.findAll();
	}

	public void deletecomment(String id) {
		// TODO Auto-generated method stub
		usercommentrepo.deleteByUserUsername(id);
	}
}
