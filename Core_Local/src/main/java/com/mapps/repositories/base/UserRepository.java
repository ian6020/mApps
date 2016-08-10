package com.mapps.repositories.base;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mapps.models.base.Organization;
import com.mapps.models.base.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	Page<User> findByFirstnameLike(String firstname,Pageable pageable);
	Page<User> findByLastnameLike(String lastname,Pageable pageable);
	Page<User> findByFirstnameLikeAndLastnameLike(String firstname, String lastname, 
			Pageable pageable);
	User findByUsernameAndOrganization(String username, Organization org);
	User findByUsername(String username);
	
}
