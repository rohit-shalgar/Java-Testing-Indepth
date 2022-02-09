package com.rohit.practise.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@ToString
@Data
public class Course {

    @Id
    @GeneratedValue
    public int id;

    public String name;


    public Course(String name) {

        this.name = name;

    }

}
