package com.gabrielfigueiredol.LiterAluraChallenge.view;

import com.gabrielfigueiredol.LiterAluraChallenge.model.Book;
import com.gabrielfigueiredol.LiterAluraChallenge.model.Person;
import com.gabrielfigueiredol.LiterAluraChallenge.service.BooksApi;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private BooksApi booksApi = new BooksApi();
    private final String WEBURL = "https://gutendex.com//books?search=";

    public void showMenu() {
        var option = -1;

        while (option != 0) {
            var menu = """
                    Escolha uma opção:
                    1 - Buscar livro pelo título
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
                    System.out.println("Digite o titulo do livro: ");
                    var bookName = sc.nextLine();
                    var response = booksApi.getData(WEBURL + bookName.replace(" ", "%20"));
                    break;
                case 2:
                    System.out.println("Opção 2");
                    break;
                case 3:
                    System.out.println("Opção 3");
                    break;
                case 4:
                    System.out.println("Opção 4");
                    break;
                case 5:
                    System.out.println("Opção 5");
                    break;
                case 0:
                    System.out.println("Fechando a aplicação");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        }
    }

}
