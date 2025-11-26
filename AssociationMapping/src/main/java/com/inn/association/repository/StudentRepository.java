package com.inn.association.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.association.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
