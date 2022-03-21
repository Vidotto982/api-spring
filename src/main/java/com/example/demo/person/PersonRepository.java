package com.example.demo.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findPersonByName(String name);
    Optional<Person> findPersonByLastname(String lastname);
    Optional<Person> findPersonByCountry(String country);

}