package com.rohit.practise.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Data
public class Passport {

    @Id
    @GeneratedValue
    public int id;

    public String number;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    public Student student;
    //Student here is the owning side of the relationship with passport
    //This avoids using student id and passport id in the both student and passport tables
    //mappedBy - is the variable in the owning table of the relationship.

    public Passport(String number) {

        this.number = number;

    }

}
