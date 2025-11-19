package com.inn.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inn.employee.entity.Employee;
import com.inn.employee.exceptions.EmployeeNotFoundException;
import com.inn.employee.repository.FirstEmployeeRepository;
import com.inn.employee.repository.SecondEmployeeRepository;
import com.inn.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired(required = true)
	@Qualifier(value = "FirstEmployeeRepository")
	private FirstEmployeeRepository firstEmpRepository;

	@Autowired(required = true)
	@Qualifier(value = "SecondEmployeeRepository")
	private SecondEmployeeRepository secondEmpRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		secondEmpRepository.save(employee);
		return firstEmpRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee employee = firstEmpRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("employee not found for given id:" + id));
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return firstEmpRepository.findAll();
	}

}
