package com.rohit.practise.database.repository;

import com.rohit.practise.database.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Objects;

@Repository
@Transactional //transaction - sequence of steps, delete the record and save. need to run in single transaction, if anything fails entire transaction should be rolled back.
@Slf4j
public class CourseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Course findCourseById(Integer id) {

        return entityManager.find(Course.class, id);

    }

    public void deleteCourseById(Integer id){

        Course course = findCourseById(id);
        entityManager.remove(course);

    }

    public void saveCourse(Course course){

        if(Objects.isNull(course.getId())){
            entityManager.persist(course);
            return;
        }
        entityManager.merge(course);
    }

}
