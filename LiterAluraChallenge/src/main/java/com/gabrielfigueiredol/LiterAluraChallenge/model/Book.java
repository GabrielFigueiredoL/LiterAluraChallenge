package com.gabrielfigueiredol.LiterAluraChallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Book {
    @Id
    private Integer id;
    private String title;
    private List<String> languages;
    @JsonAlias("download_count")
    private Integer downloadCount;
    @ManyToOne
    private Person author;

    public Book() {}

    public Book(Integer id, String title, Person author, List<String> languages, Integer downloadCount) {
        this.id = id;
        this.languages = languages;
        this.author = author;
        this.title = title;
        this.downloadCount = downloadCount;
    }

    public Book(BookResponse bookResponse) {
        id = bookResponse.id();
        author = bookResponse.authors().get(0);
        title = bookResponse.title();
        languages = bookResponse.languages();
        downloadCount = bookResponse.downloadCount();
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


    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
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
                "\nAutores: " + getAuthor().getName() +
                "\nIdiomas: " + getLanguages().stream()
                .collect(Collectors.joining(", ")) +
                "\nNúmero de downloads: " + getDownloadCount();
    }
}
