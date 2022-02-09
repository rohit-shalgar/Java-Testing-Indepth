package com.rohit.practise.database.repository;

import com.rohit.practise.database.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person findbyId(Integer id) {

        return entityManager.find(Person.class, id);

    }

    public Person update(Person person) {

        log.debug("Following person was added to the db : {}", person);
        return entityManager.merge(person);

    }

    public void deletePerson(Person person) {

        entityManager.remove(person);

    }

    public List<Person> findAllPersons() {

        TypedQuery<Person> findAllPersons = entityManager.createNamedQuery("find-all-persons", Person.class);
        return findAllPersons.getResultList();

    }

}
