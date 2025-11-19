package com.inn.stream;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

	private Integer id;

	private String name;

	private String dept;

	private List<Project> projects;

	private Double salary;

	private String gender;

}
