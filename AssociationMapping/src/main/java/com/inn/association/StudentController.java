package com.inn.association;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inn.association.entity.Student;
import com.inn.association.repository.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repository.save(student);
	}

	@GetMapping
	public List<Student> findAllStudent() {
		return repository.findAll();
	}

}
