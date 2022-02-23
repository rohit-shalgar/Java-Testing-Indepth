package com.rohit.practise.database;

import com.rohit.practise.database.repository.CourseRepository;
import com.rohit.practise.database.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class MasteringSpringDataJpaApplication implements CommandLineRunner {

	private CourseRepository courseRepository;
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(MasteringSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//courseRepository.addReviews();
		studentRepository.addStudentAndCourseHardCoded();
	}
}
