package com.inn.association.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.association.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	// same fieldName which is there in student entity all mapping fieldNames to solve n+1 problem
	@EntityGraph(attributePaths = {"addressList","laptop"})
	List<Student> findAll();
}
