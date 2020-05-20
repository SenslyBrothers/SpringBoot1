package com.example.masterspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masterspring.entities.User;
import com.example.masterspring.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public Optional<User> getUser(User user) {
		Integer id = user.getId();
		return repo.findById(id);
	}
	
	@Override
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	
	
	

}
