package com.example.masterspring;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.masterspring.entities.Student;
import com.example.masterspring.repos.StudentRepository;
import com.example.masterspring.service.StudentService;




@SpringBootTest
class SimplerestApplicationTests {

	@Autowired
	private StudentRepository repo;

	@Autowired
	private StudentService service;
	
	@Test
	public void test() {
		
			   
	}
}
