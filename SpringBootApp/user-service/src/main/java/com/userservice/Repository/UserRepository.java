package com.userservice.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.userservice.Entity.User;





public interface UserRepository  extends CrudRepository<User, Integer>{
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
