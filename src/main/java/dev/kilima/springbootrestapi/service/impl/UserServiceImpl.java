package dev.kilima.springbootrestapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import dev.kilima.springbootrestapi.dto.UserDto;
import dev.kilima.springbootrestapi.entity.User;
import dev.kilima.springbootrestapi.exception.EmailAlreadyExistException;
import dev.kilima.springbootrestapi.exception.ResourceNotFoundException;
import dev.kilima.springbootrestapi.mapper.AutoUserMapper;
import dev.kilima.springbootrestapi.mapper.UserMapper;
import dev.kilima.springbootrestapi.repository.UserRepository;
import dev.kilima.springbootrestapi.service.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	private ModelMapper modelMapper;
	
	

	@Override
	public UserDto createUser(UserDto userDto) {

		// Convert UserDto to User JPA entity
		// User user = UserMapper.mapToUser(userDto);
		
		User user = modelMapper.map(userDto, User.class);
		
		//User user = AutoUserMapper.MAPPER.mapToUser(userDto);
		
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExistException("Email Already Exists for User");
		}

		User savedUser = userRepository.save(user);

		// Convert User JPA entity to UserDto
		//UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		//UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(
					() -> new ResourceNotFoundException("User", "id", userId)
				);
		//User user = optionalUser.get(); .get was used to get value from optional
		//return UserMapper.mapToUserDto(user);
		return modelMapper.map(user, UserDto.class);
		//return AutoUserMapper.MAPPER.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		//return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		
		//return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
		//		.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).orElseThrow(
					() -> new ResourceNotFoundException("User", "id", user.getId())
				);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
		//return UserMapper.mapToUserDto(updatedUser);
		return modelMapper.map(updatedUser, UserDto.class);
		//return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		
		User existingUser = userRepository.findById(userId).orElseThrow(
			() -> new ResourceNotFoundException("User", "id", userId)
		);
		
		userRepository.deleteById(userId);

	}

}
