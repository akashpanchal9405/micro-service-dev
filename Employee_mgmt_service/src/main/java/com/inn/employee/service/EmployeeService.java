package com.inn.employee.service;

import java.util.List;

import com.inn.employee.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public Employee getEmployeeById(Integer id);
	
	public List<Employee> getAllEmployee();

}
