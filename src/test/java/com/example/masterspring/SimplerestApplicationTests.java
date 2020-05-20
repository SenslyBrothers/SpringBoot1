package com.example.masterspring;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.masterspring.entities.Student;
import com.example.masterspring.entities.User;
import com.example.masterspring.repos.StudentRepository;
import com.example.masterspring.repos.UserRepository;
import com.example.masterspring.service.StudentService;
import com.example.masterspring.service.UserService;




@SpringBootTest
class SimplerestApplicationTests {

	@Autowired
	private StudentRepository repo;

	@Autowired
	private StudentService service;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		
		User user = new User();
		user.setId(null);
		user.setUserName("abc2");
		user.setPassword("abc2");
		user.setEmail("email2");
		userService.saveUser(user);
			   
	}
}
