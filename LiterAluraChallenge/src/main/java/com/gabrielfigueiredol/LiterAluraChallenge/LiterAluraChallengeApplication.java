package com.gabrielfigueiredol.LiterAluraChallenge;

import com.gabrielfigueiredol.LiterAluraChallenge.service.BookService;
import com.gabrielfigueiredol.LiterAluraChallenge.service.PersonService;
import com.gabrielfigueiredol.LiterAluraChallenge.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraChallengeApplication implements CommandLineRunner {
	@Autowired
	private BookService bookService;

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu main = new Menu(bookService, personService);
		main.showMenu();
	}
}
