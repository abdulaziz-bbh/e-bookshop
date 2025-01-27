package org.example.controller;

import org.example.serivce.AuthorService;
import org.example.serivce.BookService;
import org.example.util.Utils;

import java.util.List;
import java.util.Scanner;

public class Controller {

    public AuthorService authorService = new AuthorService();
    public BookService bookService = new BookService();

    public void commander(){//CRUD create read update delete
        Utils.println("Author bo'limiga o'tish uchun 1 ni bosing: ");
        Utils.println("Book bo'limiga o'tish uchun 2 ni bosing: ");
        int command = Utils.scanner().nextInt();
        switch (command) {
            case 1:
                authorSession();
            case 2:
                bookSession();
        }

    }

    public void bookSession(){
        System.out.println("Book qo'shish uchun 6 ni bosing");
        System.out.println("Book update qilish uchun 7 ni bosing");
        System.out.println("Book get qilish uchun 8 ni bosing");
        System.out.println("Book get all qilish uchun 9 ni bosing");
        System.out.println("Book delete qilish uchun 10 ni bosing");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        switch (command){
            case 1:
                authorService.create();
                commander();
            case 4:
                Utils.printListAsTable(authorService.findAll());
                commander();
        }
    }

    public void authorSession(){
        System.out.println("Author qo'shish uchun 1 ni bosing");
        System.out.println("Author update qilish uchun 2 ni bosing");
        System.out.println("Author get qilish uchun 3 ni bosing");
        System.out.println("Author get all qilish uchun 4 ni bosing");
        System.out.println("Author get delete qilish uchun 5 ni bosing");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        switch (command){
            case 1:
                authorService.create();
                authorSession();
            case 2:
                authorService.update();
                authorSession();
            case 3:
                Utils.printListAsTable(List.of(authorService.findById()));
                authorSession();
            case 4:
                Utils.printListAsTable(authorService.findAll());
                authorSession();
            case 5:
                authorService.delete();
                authorSession();
            case 0:
                commander();
        }
    }
}
