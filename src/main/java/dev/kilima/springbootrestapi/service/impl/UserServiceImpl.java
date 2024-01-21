package dev.kilima.springbootrestapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.kilima.springbootrestapi.dto.UserDto;
import dev.kilima.springbootrestapi.entity.User;
import dev.kilima.springbootrestapi.mapper.UserMapper;
import dev.kilima.springbootrestapi.repository.UserRepository;
import dev.kilima.springbootrestapi.service.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {

		// Convert UserDto to User JPA entity
		User user = UserMapper.mapToUser(userDto);
		
		User savedUser = userRepository.save(user);

		// Convert User JPA entity to UserDto
		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

		return savedUserDto;
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		return optionalUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);

	}

}
