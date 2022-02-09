package com.rohit.practise.database.service;

import com.rohit.practise.database.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Optional<Person> getPerson(int id);

    void createPerson(Person person);

    void deletePerson(int id);

    List<Person> getAllPersons();

}
