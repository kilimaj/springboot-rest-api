package dev.kilima.springbootrestapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long id;
	
	// User first name should not be null or empty
	@NotEmpty(message = "User first name should not be null or empty")
	private String firstName;
	
	// User Last name should not be null or empty
	@NotEmpty(message = "User Last name should not be null or empty")
	private String lastName;
	
	// User email name should not be null or empty
	// Email address should be valid format
	@NotEmpty(message = "User email name should not be null or empty")
	@Email(message = "Email address should be valid format")
	private String email;
	//private String emailAddress;
}
