package com.rohit.practise.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Data
public class Student {

    @Id
    @GeneratedValue
    public int id;

    public String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    public Passport passport;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
               joinColumns = @JoinColumn(name = "STUDENT_ID"),
               inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    public List<Course> courses = new ArrayList<>();
    /*
        mANY TO MANY creates a joint table student_course, course_student
        here we have made student the owning side of the relationship.
        so only one table will be created by the name student_course and
        columns will be student_id and course_id
     */

    public Student(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
