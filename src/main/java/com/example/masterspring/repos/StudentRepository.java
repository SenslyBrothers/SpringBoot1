package com.example.masterspring.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.masterspring.entities.Student;

@Repository
@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}
