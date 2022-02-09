package com.rohit.practise.database.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "PERSON")
@NamedQuery(name = "find-all-persons", query = "select p from Person p")
//Named query lets you fire an actual query, and it is identified by the query name.
public class Person {

    @Id
    @GeneratedValue
    public int id;

    public String name;

    public String location;

    @Column(name = "birth_date")
    public Date birthDate;

    public Person(String name, String location, Date birthDate) {

        this.name = name;
        this.location = location;
        this.birthDate = birthDate;

    }

}
