package com.example.masterspring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.masterspring.repos.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.masterspring.entities.User user = repository.getUserByuserName(username);
		
		
//		return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
		return new User("foo","foo",new ArrayList<>());
		
	}

}
