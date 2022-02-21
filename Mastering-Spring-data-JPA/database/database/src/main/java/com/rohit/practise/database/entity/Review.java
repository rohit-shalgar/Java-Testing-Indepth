package com.rohit.practise.database.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@ToString
@Data
public class Review {

    @Id
    @GeneratedValue
    public int id;

    public int ratings;

    public String description;


    public Review(String description,int ratings) {

        this.ratings = ratings;
        this.description = description;

    }

}
