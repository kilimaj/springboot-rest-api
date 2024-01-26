package dev.kilima.springbootrestapi.mapper;

import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.kilima.springbootrestapi.dto.UserDto;
import dev.kilima.springbootrestapi.entity.User;

@Mapper
public interface AutoUserMapper {
	// Incase the values are different this annotation can be used
	// @Mapping(source = "email", target = "emailAddress")
	
	// Mapstruct provides implementation at runtime as follows
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	UserDto mapToUserDto(User user);
	
	User mapToUser(UserDto userDto);
}
