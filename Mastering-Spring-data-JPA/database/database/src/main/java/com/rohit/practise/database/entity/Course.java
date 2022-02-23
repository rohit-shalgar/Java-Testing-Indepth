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
public class Course {

    @Id
    @GeneratedValue
    public int id;

    public String name;

    @OneToMany(mappedBy = "course")
    public List<Review> reviews;
    //One course can have many reviews
    //we can not have multiple review ids in review id field, thats a bad db design
    //mappedBy indicates that review table is the owner of this relationship.

    @ManyToMany(mappedBy = "courses")
    public List<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public boolean addReview(Review review){
       return this.reviews.add(review);
    }

    public boolean removeAReview(Review review){
        return this.reviews.remove(review);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
