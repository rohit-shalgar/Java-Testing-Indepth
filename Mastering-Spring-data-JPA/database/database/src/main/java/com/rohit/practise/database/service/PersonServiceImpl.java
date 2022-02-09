package com.rohit.practise.database.service;

import com.rohit.practise.database.entity.Person;
import com.rohit.practise.database.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public Optional<Person> getPerson(int id) {

        Optional<Person> person = Optional.ofNullable(personRepository.findbyId(id));
        if (person.isEmpty()) {
            throw new EntityNotFoundException("The person with the id -" + id + " does not exist");
        }

        return person;

    }

    @Override
    public void createPerson(Person person) {

        personRepository.update(person);

    }

    @Override
    public void deletePerson(int id) {

        personRepository.deletePerson(getPerson(id).get());

    }

    @Override
    public List<Person> getAllPersons() {

        return personRepository.findAllPersons();

    }
}
