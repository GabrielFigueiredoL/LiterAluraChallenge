package com.gabrielfigueiredol.LiterAluraChallenge.repository;

import com.gabrielfigueiredol.LiterAluraChallenge.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByNameAndBirthYearAndDeathYear(String name, Integer birthYear, Integer deathYear);

    @Query("SELECT p FROM Person p WHERE p.birthYear < :year AND p.deathYear > :year")
    List<Person> findAuthorsByYear(Integer year);

}
