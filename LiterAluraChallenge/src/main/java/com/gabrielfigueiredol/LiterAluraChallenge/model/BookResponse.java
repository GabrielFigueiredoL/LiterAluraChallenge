package com.gabrielfigueiredol.LiterAluraChallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookResponse(
         Integer id,
         String title,
         List<Person> authors,
         List<String>languages,
         @JsonAlias("download_count")
         Integer downloadCount
) {
    @Override
    public String toString() {
        return "---------- LIVRO ----------" +
                "\nTitulo: " + title() +
                "\nAutores: " + authors.get(0).getName() +
                "\nIdiomas: " + languages().stream()
                .collect(Collectors.joining(", ")) +
                "\nNúmero de downloads: " + downloadCount();
    }
}
