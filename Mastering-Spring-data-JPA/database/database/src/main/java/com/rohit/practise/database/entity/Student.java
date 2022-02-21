package com.rohit.practise.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

    public Student(String name) {
        this.name = name;
    }

}
