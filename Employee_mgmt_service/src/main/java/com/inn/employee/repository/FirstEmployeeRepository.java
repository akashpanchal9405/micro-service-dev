package com.inn.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.employee.entity.Employee;

@Repository
public interface FirstEmployeeRepository extends JpaRepository<Employee, Integer> {

}
