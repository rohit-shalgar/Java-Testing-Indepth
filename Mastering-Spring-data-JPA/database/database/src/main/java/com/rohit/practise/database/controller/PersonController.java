package com.rohit.practise.database.controller;


import com.rohit.practise.database.entity.Person;
import com.rohit.practise.database.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {

        return ResponseEntity.of(personService.getPerson(id));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson() {

        Date date;
        date = new Date();
        date.setTime(System.currentTimeMillis());
        personService.createPerson(new Person("Rohit2", "GDLA", date));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id) {

        personService.deletePerson(id);

    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {

        return ResponseEntity.ok(personService.getAllPersons());

    }

}
