package com.example.masterspring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import javax.transaction.Transaction;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.masterspring.entities.Student;
import com.example.masterspring.repos.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{


	@Autowired
	private StudentRepository repo;
	

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public List<Student> allStudents() {
		
//		Session currentSession = entityManager.unwrap(Session.class);
//		Query<Student> query = currentSession.createQuery("from Student", Student.class);
//		
//		List<Student> list = query.getResultList();		
//		return list;
		return repo.findAll();
	}

	@Override
	public Optional <Student> getStudentById(Integer id) {
		
		Optional< Student >  getStudent = this.repo.findById(id);
		
		 if (getStudent.isPresent()) {
	            return getStudent;
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + id);
	        }
	}

	@Override
	public Student update(Student stuent,Integer id) {
		
		Student getStudent = this.repo.findById(id).get();
		getStudent.setName(stuent.getName());
		getStudent.toString();
		return repo.save(getStudent);
	}

	
	@Override
	public void delete(Integer id) {
	Optional< Student >  getStudent = this.repo.findById(id);
		
		 if (getStudent.isPresent()) {
	            repo.deleteById(id);
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + id);
	        }
	}
	

}
