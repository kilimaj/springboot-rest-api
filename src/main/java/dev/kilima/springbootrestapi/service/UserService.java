package dev.kilima.springbootrestapi.service;

import java.util.List;

import dev.kilima.springbootrestapi.dto.UserDto;
import dev.kilima.springbootrestapi.entity.User;

public interface UserService {
	UserDto createUser(UserDto user);
	
	User getUserById(Long userId);
	
	List<User> getAllUsers();
	
	User updateUser(User user);
	
	void deleteUser(Long userId);
}
