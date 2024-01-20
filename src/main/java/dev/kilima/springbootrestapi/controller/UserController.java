package dev.kilima.springbootrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kilima.springbootrestapi.entity.User;
import dev.kilima.springbootrestapi.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	private UserService userService;
	
	// build create User REST API
	@PostMapping("create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	//Build Get user by Id REST API
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
		User user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
