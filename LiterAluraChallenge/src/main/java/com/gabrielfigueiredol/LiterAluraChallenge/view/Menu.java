package com.gabrielfigueiredol.LiterAluraChallenge.view;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    Escolha uma opção:
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar aytires registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar lviros em um determinado idioma
                    0 - Sair
                    """;
            System.out.println(menu);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("opção 1");
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