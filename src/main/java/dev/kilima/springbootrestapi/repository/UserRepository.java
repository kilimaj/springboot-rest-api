package dev.kilima.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.kilima.springbootrestapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
