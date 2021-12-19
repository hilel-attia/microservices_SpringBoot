package com.userservice.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.userservice.Entity.ERole;
import com.userservice.Entity.Role;





public interface RoleRepository extends CrudRepository<Role, Integer> {

	
	Optional<Role> findByName(ERole name);

}
