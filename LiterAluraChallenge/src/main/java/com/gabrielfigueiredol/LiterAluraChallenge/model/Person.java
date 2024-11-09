package com.gabrielfigueiredol.LiterAluraChallenge.model;

import java.util.Objects;

public class Person {
    private Integer birthYear;
    private Integer deathYear;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(birthYear, person.birthYear) && Objects.equals(deathYear, person.deathYear) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthYear, deathYear, name);
    }
}
