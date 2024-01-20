package dev.kilima.springbootrestapi.service;

import java.util.List;

import dev.kilima.springbootrestapi.entity.User;

public interface UserService {
	User createUser(User user);
	
	User getUserById(Long userId);
	
	List<User> getAllUsers();
}
