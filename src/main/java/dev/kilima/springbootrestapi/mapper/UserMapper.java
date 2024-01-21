package dev.kilima.springbootrestapi.mapper;

import dev.kilima.springbootrestapi.dto.UserDto;
import dev.kilima.springbootrestapi.entity.User;

public class UserMapper {

	// Convert User JPA Entity into User DTO
	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
			);
		return userDto;
	}
	
	// Convert userDto into user Entity
	public static User mapToUser(UserDto userDto) {
		User user = new User(
			userDto.getId(),
			userDto.getFirstName(),
			userDto.getLastName(),
			userDto.getEmail()
		);
		return user;
	}
}
