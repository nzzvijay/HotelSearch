package com.nzzvijay.hotelsearch;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nzzvijay.Model.UserComment;

public interface Usercommentrepo extends CrudRepository<UserComment, Integer>{

	@Transactional
    public void deleteByUserUsername(String userName);

}
