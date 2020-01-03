package com.bridgelabz.fundoonotes.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.User;

import java.lang.String;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByEmail(String email);
	Optional<User> findById(String id);
	
	

	
}
