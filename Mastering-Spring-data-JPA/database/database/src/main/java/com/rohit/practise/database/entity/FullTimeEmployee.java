package com.rohit.practise.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Data
public class FullTimeEmployee extends Employee {

    public int salary;

    public FullTimeEmployee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

}
