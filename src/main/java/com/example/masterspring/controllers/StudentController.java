package com.example.masterspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.masterspring.entities.Student;
import com.example.masterspring.service.StudentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping
public class StudentController {
	
	@Autowired
	private StudentService service;
	
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
	 public Student updateStudent(@PathVariable Integer id,@RequestBody Student student) {
		 
		 return service.update(student,id);
	 }
	 
	 @DeleteMapping("/student/{id}")
	 public void deleteStudent(@PathVariable Integer id) {
		 service.delete(id);
	 }
	 
	 
	 
	
	
	


	
}
