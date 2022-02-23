package com.rohit.practise.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Data
public class PartTimeEmployee extends Employee {

    public int hourlyWage;

    public PartTimeEmployee(String name, int hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

}
