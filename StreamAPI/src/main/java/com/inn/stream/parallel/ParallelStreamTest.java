package com.inn.stream.parallel;

import java.util.List;

import com.inn.stream.Employee;
import com.inn.stream.StreamApiApplication;

public class ParallelStreamTest {

	public static void main(String[] args) {
		// In stream elements process in sequential order by single core or cpu
		// but in parallel stream elements process parallel by multiple cores or cpu

		// now print 1 to 100 number by using stream and check it's performance or time
		// taken
//		long start = System.currentTimeMillis();
//		IntStream.range(1, 100000).forEach(System.out::println);
//		long end = System.currentTimeMillis();
//		System.out.println("total time milli seconds : " + (end - start));

//		long start1 = System.currentTimeMillis();
//		IntStream.range(1, 100000).parallel().forEach(System.out::println);
//		long end1 = System.currentTimeMillis();
//		System.out.println(
//				"parallel stream total time of execution : " + (end1 - start1) + " sequential : " + (end - start));

		List<Employee> empList = StreamApiApplication.getAllEmployees();
		// stream() performance test

		long start2 = System.currentTimeMillis();
		double salaryWithStream = empList.stream().map(Employee::getSalary).mapToDouble(sal -> sal).average()
				.getAsDouble();
		long end2 = System.currentTimeMillis(); 
		System.out.println(salaryWithStream);
		System.out.println("total time of stream : " + (end2 - start2));

		long start3 = System.currentTimeMillis();
		double salWithParallelStream = empList.parallelStream().map(Employee::getSalary).mapToDouble(sal -> sal)
				.average().getAsDouble();
		System.out.println(salWithParallelStream);
		long end3 = System.currentTimeMillis();
		System.out.println("total time of stream : " + (end3 - start3));

	}

}
