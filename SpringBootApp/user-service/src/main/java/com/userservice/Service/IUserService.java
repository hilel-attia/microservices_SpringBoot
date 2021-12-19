package com.userservice.Service;

import java.util.List;

import com.userservice.Entity.User;







public interface IUserService {
	
	public Long register(User user);
	public List<User> getAllUsers();

}
