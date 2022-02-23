package com.rohit.practise.database.repository;

import com.rohit.practise.database.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAllEmployees() {
        Query query = entityManager.createQuery(
                "select e from Employee e", Employee.class);

        return query.getResultList();
    }

    public void insertEmployee(Employee employee) {
        entityManager.persist(employee);
    }

}

