package com.example.masterspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.masterspring.entities.AuthenticationRequest;
import com.example.masterspring.entities.AuthenticationResponse;
import com.example.masterspring.entities.Student;
import com.example.masterspring.service.MyUserDetailsService;
import com.example.masterspring.service.StudentService;
import com.example.masterspring.util.JwtUtil;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello Udula Lets Do this!";
	}
	
	@RequestMapping(value="/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		}catch (Exception e) {
			
			throw new Exception("Incorect username or password",e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
				
	}
	
	
	
	
	
	 @GetMapping("/students")
	 public List<Student> getAllStudents(){
		return service.allStudents();
	 }
	 
	 @GetMapping("/student/{id}")
	 public Student getStudent(@PathVariable Integer id) {
		 
		 if(!service.getStudentById(id).isEmpty()) {
			 return service.getStudentById(id).get();
		 }else{
			 return null;
		 }
	 }
	 
	 
	 @PostMapping("/student")
	 public Student saveStudent(@RequestBody Student student) {
		 return service.saveStudent(student);
	 }
	 
	 
	 @PutMapping("/student/{id}")
	 public Student updateStudent(@PathVariable Integer id,@Validated @RequestBody Student student) {
		 return service.update(student,id);
	 }
	 
	 @DeleteMapping("/student/{id}")
	 public void deleteStudent(@PathVariable Integer id) {
		 service.delete(id);
	 }
	 
	 
	 
	
	
	


	
}
