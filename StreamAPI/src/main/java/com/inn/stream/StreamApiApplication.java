package com.inn.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiApplication {

	// list of employee with project data to process this elements by stream api's
	public static List<Employee> getAllEmployees() {
		Project proj1 = Project.builder().projectCode("P001").name("Alpha").client("ABC Corp").buLeadName("Alice")
				.build();
		Project proj2 = Project.builder().projectCode("P002").name("Beta").client("XYZ Corp").buLeadName("Bob").build();
		Project proj3 = Project.builder().projectCode("P003").name("Gamma").client("ABC Corp").buLeadName("Alice")
				.build();
		Project proj4 = Project.builder().projectCode("P004").name("Delta").client("TechWorld Corp")
				.buLeadName("Charlie").build();
		Project proj5 = Project.builder().projectCode("P005").name("Epsilon").client("MoneyMatter").buLeadName("Daniel")
				.build();
		Project proj6 = Project.builder().projectCode("P006").name("Zeta").client("SmartTechs").buLeadName("Eva")
				.build();
		Project proj7 = Project.builder().projectCode("P007").name("Eta").client("BrandBoost").buLeadName("George")
				.build();
		Project proj8 = Project.builder().projectCode("P008").name("Theta").client("InnoSoft").buLeadName("Hannah")
				.build();
		Project proj9 = Project.builder().projectCode("P009").name("Iota").client("FastTrack").buLeadName("Ian")
				.build();
		Project proj10 = Project.builder().projectCode("P0010").name("Kappa").client("DigitalWave")
				.buLeadName("Jessica").build();

		Employee emp1 = Employee.builder().id(1).name("John Doe").dept("Development")
				.projects(Arrays.asList(proj1, proj2)).salary(80000.00).gender("Male").build();
		Employee emp2 = Employee.builder().id(2).name("Jane Smith").dept("Development").projects(Arrays.asList(proj3))
				.salary(740000.00).gender("Female").build();
		Employee emp3 = Employee.builder().id(3).name("Rober Brown").dept("sales").projects(Arrays.asList(proj4, proj3))
				.salary(10000.00).gender("Male").build();
		Employee emp4 = Employee.builder().id(4).name("Lisa White").dept("HR").projects(Arrays.asList(proj5, proj6))
				.salary(20000.00).gender("Female").build();
		Employee emp5 = Employee.builder().id(5).name("Michael Green").dept("Fianance").projects(Arrays.asList(proj7))
				.salary(30000.00).gender("Male").build();
		Employee emp6 = Employee.builder().id(6).name("Sophia Brown").dept("Development").projects(Arrays.asList(proj8))
				.salary(40000.00).gender("Female").build();
		Employee emp7 = Employee.builder().id(7).name("James Wilson").dept("Marketing").projects(Arrays.asList(proj9))
				.salary(50000.00).gender("Male").build();
		Employee emp8 = Employee.builder().id(8).name("Olivia Harris").dept("Development")
				.projects(Arrays.asList(proj10)).salary(60000.00).gender("Female").build();
		Employee emp9 = Employee.builder().id(9).name("Willian Lee").dept("Sales")
				.projects(Arrays.asList(proj9, proj10)).salary(70000.00).gender("Male").build();
		Employee emp10 = Employee.builder().id(10).name("Emily Clark").dept("Development")
				.projects(Arrays.asList(proj7, proj8)).salary(90000.00).gender("Female").build();

		return Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10);
	}

	public static void main(String[] args) {
		List<Employee> empList = getAllEmployees();

		// enhanced for loop
//		for (Employee emp : empList) {
//			System.out.println(emp);
//		}

		// forEach method
//		empList.forEach(emp -> System.out.println(emp.getName() + " : " + emp.getSalary()));

		// by using stream api
//		empList.stream().forEach(System.out::println);

		// filter()
		// get all emp from development dept and sal is greater than 90K
		List<Employee> empFromDevDept = empList.stream()
				.filter(emp -> emp.getDept().equals("Development") & emp.getSalary() > 90000)
				.collect(Collectors.toList());
//		System.out.println(empFromDevDept);

		Set<Employee> empFromDevDeptSet = empList.stream()
				.filter(emp -> emp.getDept().equals("Development") & emp.getSalary() > 90000)
				.collect(Collectors.toSet());

//		System.out.println(empFromDevDeptSet);

		Map<Integer, String> devEmp = empList.stream()
				.filter(emp -> emp.getDept().equals("Development") & emp.getSalary() > 90000)
				.collect(Collectors.toMap(Employee::getId, Employee::getName));

//		System.out.println(devEmp);

		// map()
		Set<String> uniqueDept = empList.stream().map(Employee::getDept).collect(Collectors.toSet());

//		System.out.println(uniqueDept);

		// distinct()
		List<String> distinctEmp = empList.stream().map(Employee::getDept).distinct().collect(Collectors.toList());

//		System.out.println(distinctEmp);

		// process list of list of elements using map() and check it's limitations
		List<Stream<String>> mapListOfList = empList.stream()
				.map(emp -> emp.getProjects().stream().map(Project::getName)).collect(Collectors.toList());

//		System.out.println(mapListOfList);//o/p = [java.util.stream.ReferencePipeline$3@448139f0,

		// flatMap() to process list of list of elements
		List<String> flatMap = empList.stream().flatMap(emp -> emp.getProjects().stream()).map(Project::getName)
				.collect(Collectors.toList());

//		System.out.println(flatMap);

		// sorted() in ascending order by salary
		List<Employee> ascSortedEmployees = empList.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());

//		System.out.println(ascSortedEmployees);

		// sorted() in descending order by salary
		List<Employee> descSortedEmployees = empList.stream()
				.sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
				.collect(Collectors.toList());

//		System.out.println(descSortedEmployees);

		// max() highest paid employee

		Optional<Employee> hightestPaidEmp = empList.stream().max(Comparator.comparingDouble(Employee::getSalary));

//		System.out.println(hightestPaidEmp);

		// min() lowest paid employee

		Optional<Employee> lowestPaidEmp = empList.stream().min(Comparator.comparingDouble(Employee::getSalary));

//		System.out.println(lowestPaidEmp);

		// how many male emp and female emp so for we need to group based on gender
		// groupingBy()

		Map<String, List<Employee>> empGenderCategory = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender));

//		System.out.println(empGenderCategory);

		// groupingBy() get gender as key and value as list of empName ex:
		// [Gender,[listOfEmpNames]]
		Map<String, List<String>> empGenderListByName = empList.stream().collect(
				Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
//		System.out.println(empGenderListByName);

		// groupingBy() get employee count based on gender ex: [Gender,countOfEmp]

		Map<String, Long> empCountGroupByGender = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

//		System.out.println(empCountGroupByGender);

		// get first emp based on given department
		// findFirst()

		Optional<Employee> findFirstFromDept = empList.stream().filter(emp -> emp.getDept().equals("Development"))
				.findFirst();
//		findFirstFromDept.ifPresent(emp -> System.out.println(emp.getName()));// to avoid NPException

		// if data is not there in that dept than return Dummy Employee object
		// orElse()
		Employee returnEmptyEmpObject = empList.stream().filter(emp -> emp.getDept().equals("NFE")).findFirst()
				.orElse(new Employee());
//		System.out.println(returnEmptyEmpObject);

		// if data isn't available we can also throw exception
		// orElseThrow()

		Employee orElseThrow = empList.stream().filter(emp -> emp.getDept().equals("Development")).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Employee not found..."));

//		System.out.println(orElseThrow);

		// in parallelStream based on condition if any record found then process further
		// logic for that findAny() is useful
		// findAny()

		Employee findAny = empList.parallelStream().filter(emp -> emp.getDept().equals("Development")).findAny()
				.orElseThrow(() -> new IllegalArgumentException("Employee not found..."));

//		System.out.println(findAny);

		// based on any condition if match found then return true or false using
		// anyMatch()

		boolean anyMatch = empList.stream().anyMatch(emp -> emp.getDept().equals("HR"));

//		System.out.println("is there any emp from perticular dept: " + anyMatch);

		// based on any condition if all records satisfied then only allMatch() return
		// true
		boolean allMatch = empList.stream().allMatch(emp -> emp.getSalary() > 5000);

//		System.out.println("is there allMatch emp from above condtion: " + allMatch);

		// if based on condition nothing is matched then noneMatch() return true

		boolean noneMatch = empList.stream().noneMatch(emp -> emp.getDept().equals("abc"));

//		System.out.println(noneMatch);

		// limit() only top records will get
		List<Employee> limit = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3)
				.collect(Collectors.toList());

//		System.out.println(limit);

		// skip() it will skip number of elements
		List<Employee> skip = empList.stream().skip(4).collect(Collectors.toList());
//		System.out.println(skip);

		// mapToInt() and sum()
		Stream<Integer> integerList = Stream.of(1, 2, 4, 5, 67, 4, 3, 3, 6, 3, 3, 2);
//		int sum = integerList.mapToInt(i -> i).sum();
//		System.out.println(sum);

		// reduce() -> combine the stream of integer and produce the sum result
//		Integer reduceSum = integerList.reduce(0, (a, b) -> a + b);
//		System.out.println(reduceSum);

		// reduce() with methodReference
//		Optional<Integer> reduceWithMReference = integerList.reduce(Integer::sum);
//		System.out.println(reduceWithMReference);

		// reduce() to get max number
//		Optional<Integer> reduceMaxNum = integerList.reduce(Integer::max);
//		System.out.println(reduceMaxNum);
		
		//reduce() to get min number
		Optional<Integer> reduceMinNum = integerList.reduce(Integer::min);
		System.out.println(reduceMinNum.get());
	}

}
