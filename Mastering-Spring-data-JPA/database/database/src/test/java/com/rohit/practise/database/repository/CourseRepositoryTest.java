package com.rohit.practise.database.repository;

import com.rohit.practise.database.entity.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findCourseByIdTest() {

        Course course = courseRepository.findCourseById(1001);

        assertThat(course).isNotNull();
        assertThat(course.getName()).isEqualTo("Learning JPA");

    }

    @Test
    @DirtiesContext //data is reverted and spring makes sure that the data remains consistent.
    public void deleteCourseByIdTest() {

        courseRepository.deleteCourseById(1002);

        assertThat(courseRepository.findCourseById(1002)).isNull();

    }

    @Test
    public void deleteCourseByIdThatDoesNotExistTest() {

        InvalidDataAccessApiUsageException exception = Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> courseRepository.deleteCourseById(1003));

        assertThat(exception).isNotNull();
        assertThat(exception.getMessage()).startsWith("attempt to create delete event with null entity");

    }

    @Test
    @DirtiesContext //data is reverted and spring makes sure that the data remains consistent.
    public void updateTheCourseTest() {

        Course course = courseRepository.findCourseById(1002);

        assertThat(course).isNotNull();
        assertThat(course.getName()).isEqualTo("JPA testing");

        course.setName("JPA testing Updated");
        courseRepository.saveCourse(course);

        Course updatedCourse = courseRepository.findCourseById(1002);

        assertThat(course).isNotNull();
        assertThat(course.getName()).isEqualTo("JPA testing Updated");

    }

    @Test
    @DirtiesContext //data is reverted and spring makes sure that the data remains consistent.
    public void saveTheNewCourseTest() {

        Course course = courseRepository.findCourseById(1);

        assertThat(course).isNull();

        Course courseToBeInserted = new Course("Microservices Course");
        courseRepository.saveCourse(courseToBeInserted);

        Course newSavedCourse = courseRepository.findCourseById(1);

        assertThat(newSavedCourse).isNotNull();
        assertThat(newSavedCourse.getName()).isEqualTo("Microservices Course");

    }

    @Test
    public void courseIdNotFoundTest() {

        assertCourseIsNotPresent();

    }

    private void assertCourseIsNotPresent() {

        assertThat(courseRepository.findCourseById(1002)).isEqualTo(null);

    }

}
