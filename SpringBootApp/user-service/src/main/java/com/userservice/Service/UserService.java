package com.userservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.Entity.User;
import com.userservice.Repository.UserRepository;







@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Long register(User user) {
		userRepository.save(user);
		return user.getId();
	}

	@Override
	public List<User> getAllUsers() {		
		return (List<User>) userRepository.findAll();
	}
	
	

}
