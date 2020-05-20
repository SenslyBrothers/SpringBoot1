package com.example.masterspring.service;

import java.util.Optional;

import com.example.masterspring.entities.User;


public interface UserService {

	public Optional<User> getUser(User user);
	public User saveUser(User user);
	
}
