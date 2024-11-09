package com.gabrielfigueiredol.LiterAluraChallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private Integer id;
    private String title;
    private List<Person> authors;
    private List<String> languages;
    private Integer downloadCount;

    public Book() {}

    public Book(Integer id, String title, List<Person> authors, List<String> languages, Integer downloadCount) {
        this.id = id;
        this.languages = languages;
        this.authors = authors;
        this.title = title;
        this.downloadCount = downloadCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "---------- LIVRO ----------" +
                "\nTitulo: " + getTitle() +
                "\nAutores: " + getAuthors().stream()
                .map(Person::getName)
                .collect(Collectors.joining(", \n")) +
                "\nIdiomas: " + getLanguages().stream()
                .collect(Collectors.joining(", ")) +
                "\nNúmero de downloads: " + getDownloadCount();
    }
}
