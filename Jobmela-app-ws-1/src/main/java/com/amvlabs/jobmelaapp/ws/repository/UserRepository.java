package com.amvlabs.jobmelaapp.ws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amvlabs.jobmelaapp.ws.io.entity.UserEntity;



@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findUserByEmail(String email);
	
	UserEntity findByFirstName(String firstName);
	
}
