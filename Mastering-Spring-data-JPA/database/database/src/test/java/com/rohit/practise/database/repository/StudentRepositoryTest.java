package com.rohit.practise.database.repository;

import com.rohit.practise.database.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    //@Test
    public void findCourseByIdTest() {



    }

    //@Test
    //@DirtiesContext //data is reverted and spring makes sure that the data remains consistent.
    public void deleteCourseByIdTest() {



    }

    //@Test
    public void deleteCourseByIdThatDoesNotExistTest() {

        InvalidDataAccessApiUsageException exception = Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> studentRepository.deleteStudentById(1003));

        assertThat(exception).isNotNull();
        assertThat(exception.getMessage()).startsWith("attempt to create delete event with null entity");

    }

    //@Test
    //@DirtiesContext //data is reverted and spring makes sure that the data remains consistent.
    public void updateTheCourseTest() {



    }

    @Test//data is reverted and spring makes sure that the data remains consistent.
    @Transactional
    @DirtiesContext
    public void saveTheNewCourseTest() {

        Student student1 = studentRepository.findStudentById(1);

        assertThat(student1).isNull();

        student1 = new Student("Rohit Test");
        studentRepository.saveStudent(student1,"sasa1213");
        Student student = studentRepository.findStudentById(1);
        System.out.println(student);
        Assertions.assertAll(

                () -> assertThat(student).isNotNull(),
                () -> assertThat(student.getName()).isEqualTo("Rohit Test"),
                () -> assertThat(student.getPassport().getNumber()).isEqualTo("sasa1213")

        );
    }

    @Test
    public void courseIdNotFoundTest() {

        assertCourseIsNotPresent();

    }

    private void assertCourseIsNotPresent() {

        assertThat(studentRepository.findStudentById(1002)).isEqualTo(null);

    }

}
