package com.gabrielfigueiredol.LiterAluraChallenge.service;

import com.gabrielfigueiredol.LiterAluraChallenge.model.Person;
import com.gabrielfigueiredol.LiterAluraChallenge.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> getAuthorsAliveInYear(Integer chosenYear) {
        return personRepository.findAuthorsByYear(chosenYear);
    }
}
