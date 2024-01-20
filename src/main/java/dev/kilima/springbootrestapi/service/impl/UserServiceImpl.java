package dev.kilima.springbootrestapi.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.kilima.springbootrestapi.entity.User;
import dev.kilima.springbootrestapi.repository.UserRepository;
import dev.kilima.springbootrestapi.service.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		return optionalUser.get();
	}

}
