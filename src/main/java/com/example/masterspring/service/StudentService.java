package com.example.masterspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.masterspring.entities.Student;

public interface StudentService {
	
	public Student saveStudent(Student student);
	
	public Optional<Student>  getStudentById(Integer id);
	
	public List<Student> allStudents();

	
	Student update(Student stuent,Integer Id);

	void delete(Integer id);
	
//	public Student updateStudent(Student student,Integer id);
	
//	public void deleteStudent(Student student);

}
