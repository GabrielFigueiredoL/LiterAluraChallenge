package com.gabrielfigueiredol.LiterAluraChallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonAlias("birth_year")
    private Integer birthYear;
    @JsonAlias("death_year")
    private Integer deathYear;
    private String name;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Person() {}

    public Person(String name, Integer birthYear, Integer deathYear) {
        this.birthYear = birthYear;
        this.name = name;
        this.deathYear = deathYear;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(birthYear, person.birthYear) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthYear, name);
    }

    @Override
    public String toString() {
        return "-----------\n" +
                "Nome do autor: " + getName() + "\n" +
                "Ano de nascimento: " + getBirthYear() + "\n" +
                "Ano de falecimento: " + getDeathYear() + "\n" +
                "Livros: [" + String.join(", ",
                getBooks().stream().map(Book::getTitle).toArray(String[]::new)) + "]";
    }
}
