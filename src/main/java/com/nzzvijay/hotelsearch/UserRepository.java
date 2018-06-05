package com.nzzvijay.hotelsearch;

import org.springframework.data.repository.CrudRepository;

import com.nzzvijay.Model.User;

public interface UserRepository extends CrudRepository<User, String>{

	public User findByUsername(String username);

}
