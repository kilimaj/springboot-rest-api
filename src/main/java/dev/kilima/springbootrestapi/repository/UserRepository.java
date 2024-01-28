package dev.kilima.springbootrestapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.kilima.springbootrestapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//Query for getting user using email
	Optional<User> findByEmail(String email);
}
