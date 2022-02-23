package com.rohit.practise.database;

import com.rohit.practise.database.entity.Employee;
import com.rohit.practise.database.entity.FullTimeEmployee;
import com.rohit.practise.database.entity.PartTimeEmployee;
import com.rohit.practise.database.repository.CourseRepository;
import com.rohit.practise.database.repository.EmployeeRepository;
import com.rohit.practise.database.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class MasteringSpringDataJpaApplication implements CommandLineRunner {

	private CourseRepository courseRepository;
	private StudentRepository studentRepository;
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(MasteringSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//courseRepository.addReviews();
		//studentRepository.addStudentAndCourseHardCoded();
		employeeRepository.insertEmployee(new PartTimeEmployee("Silvanna",50));
		employeeRepository.insertEmployee(new FullTimeEmployee("Rohit",5300));
		List<Employee> employeeList = employeeRepository.findAllEmployees();
		System.out.println(employeeList);
	}
}
