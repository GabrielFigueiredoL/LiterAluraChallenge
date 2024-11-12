package com.gabrielfigueiredol.LiterAluraChallenge.repository;

import com.gabrielfigueiredol.LiterAluraChallenge.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByNameAndBirthYearAndDeathYear(String name, Integer birthYear, Integer deathYear);
}
