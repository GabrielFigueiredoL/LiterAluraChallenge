package com.gabrielfigueiredol.LiterAluraChallenge.view;

import com.gabrielfigueiredol.LiterAluraChallenge.model.ApiResponse;
import com.gabrielfigueiredol.LiterAluraChallenge.model.Book;
import com.gabrielfigueiredol.LiterAluraChallenge.model.Person;
import com.gabrielfigueiredol.LiterAluraChallenge.service.BookService;
import com.gabrielfigueiredol.LiterAluraChallenge.service.BooksApi;
import com.gabrielfigueiredol.LiterAluraChallenge.service.ConvertData;
import com.gabrielfigueiredol.LiterAluraChallenge.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private BooksApi booksApi = new BooksApi();
    private final String WEBURL = "https://gutendex.com/books/?search=";
    private ConvertData convertData = new ConvertData();
    private BookService bookService;
    private PersonService personService;

    public Menu(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }

    public void showMenu() {
        var option = -1;

        while (option != 0) {
            var menu = """
                    Escolha uma opção:
                    1 - Buscar livro pelo título ou autor
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    0 - Sair
                    """;
            System.out.println(menu);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    getBook();
                    break;
                case 2:
                    getSavedBooks();
                    break;
                case 3:
                    getSavedAuthors();
                    break;
                case 4:
                    getAuthorsByYear();
                    break;
                case 5:
                    getBooksByLanguage();
                    break;
                case 0:
                    System.out.println("Fechando a aplicação");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        }
    }

    private ApiResponse getBookData() {
        System.out.println("Digite o titulo do livro: ");
        String bookName = sc.nextLine();
        var response = booksApi.getData(WEBURL + bookName.replace(" ", "%20"));
        return convertData.getData(response, ApiResponse.class);
    }

    private void getBook() {
        ApiResponse bookData = getBookData();
        if (bookData.count() == 0) {
            System.out.println("Livro não encontrado.");
            return;
        }

        for (int i = 0; i < bookData.results().size(); i++) {
            System.out.println((i + 1) + "- " + bookData.results().get(i));
        }
        System.out.println("Digite o número do livro que deseja salvar: ");
        int option = sc.nextInt();
        Book chosenBook = new Book(bookData.results().get(option - 1));
        System.out.println("Livro escolhido:");
        System.out.println(chosenBook);
        bookService.saveBook(chosenBook);
    }

    private void getSavedBooks() {
        List<Book> savedBooks = new ArrayList<>();
        savedBooks = bookService.findAll();
        savedBooks.forEach(System.out::println);
    }

    private void getSavedAuthors() {
        List<Person> savedAuthors = new ArrayList<>();
        savedAuthors = personService.findAll();
        savedAuthors.forEach(System.out::println);
    }

    private void getAuthorsByYear() {
        List<Person> authosByYear = new ArrayList<>();
        System.out.println("Digite o ano desejado: ");
        Integer chosenYear = sc.nextInt();
        sc.nextLine();
        authosByYear = personService.getAuthorsAliveInYear(chosenYear);
        authosByYear.forEach(System.out::println);
    }

    private void getBooksByLanguage() {
        List<Book> filteredBooks = new ArrayList<>();
        System.out.println("Selecione um idioma: ");
        System.out.println("""
                pt - português
                es - espanhol
                en - inglês
                fr - francês
                """);
        String chosenLanguage = sc.nextLine();
        filteredBooks = bookService.findByLanguage(chosenLanguage);
        filteredBooks.forEach(System.out::println);
    }
}
