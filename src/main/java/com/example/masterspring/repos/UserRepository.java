package com.example.masterspring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.masterspring.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User getUserByuserName(String username);

}
