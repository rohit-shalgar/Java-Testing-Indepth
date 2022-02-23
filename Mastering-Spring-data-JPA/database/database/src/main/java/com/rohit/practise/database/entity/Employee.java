package com.rohit.practise.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//represents this is a inheritance relation
//there are multiple options single table for all the subclasses or table each or joined with seperate columns.
@DiscriminatorColumn(name = "EMPLOYEE_TYPE")
//name of the column in a single table
public abstract class Employee {

    @Id
    @GeneratedValue
    public int id;

    public String name;

    public Employee(String name) {
        this.name = name;
    }

}
