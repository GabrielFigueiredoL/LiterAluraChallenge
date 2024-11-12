package com.gabrielfigueiredol.LiterAluraChallenge.service;

import com.gabrielfigueiredol.LiterAluraChallenge.model.Book;
import com.gabrielfigueiredol.LiterAluraChallenge.model.Person;
import com.gabrielfigueiredol.LiterAluraChallenge.repository.BookRepository;
import com.gabrielfigueiredol.LiterAluraChallenge.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;

    public void saveBook(Book book) {
        Person bookAuthor = book.getAuthor();
        Person bookAuthorExists = personRepository.findByNameAndBirthYearAndDeathYear(
                bookAuthor.getName(),
                bookAuthor.getBirthYear(),
                bookAuthor.getDeathYear());

        if (bookAuthorExists != null) {
            book.setAuthor(bookAuthorExists);
        }

        bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
