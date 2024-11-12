package com.gabrielfigueiredol.LiterAluraChallenge.repository;

import com.gabrielfigueiredol.LiterAluraChallenge.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
