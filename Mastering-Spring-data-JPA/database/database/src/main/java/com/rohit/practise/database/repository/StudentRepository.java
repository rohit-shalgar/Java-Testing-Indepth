package com.rohit.practise.database.repository;

import com.rohit.practise.database.entity.Course;
import com.rohit.practise.database.entity.Passport;
import com.rohit.practise.database.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
//transaction - sequence of steps, delete the record and save. need to run in single transaction, if anything fails entire transaction should be rolled back.
// single unit of work .
@Slf4j
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Student findStudentById(Integer id) {

        return entityManager.find(Student.class, id);

    }

    public void deleteStudentById(Integer id) {
        Student student = findStudentById(id);

        entityManager.remove(student);
    }

    public void saveStudent(Student student, String passportNumber) {
        Passport passport = new Passport(passportNumber);
      //  entityManager.persist(passport);
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void addStudentAndCourseHardCoded() {
        Student student = new Student("Silvanna");
        Course course = new Course("ManyToMany in hibernate");

        entityManager.persist(student);
        entityManager.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        entityManager.persist(student);// student is the owning side of the relationship and hence to be persisted.
    }
}
