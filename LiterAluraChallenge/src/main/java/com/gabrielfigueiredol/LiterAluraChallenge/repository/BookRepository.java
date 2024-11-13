package com.gabrielfigueiredol.LiterAluraChallenge.repository;

import com.gabrielfigueiredol.LiterAluraChallenge.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE :language MEMBER OF b.languages")
    List<Book> findBooksByLanguage(String language);
}
