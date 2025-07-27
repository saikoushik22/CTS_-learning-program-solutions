package com.example.library;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = context.getBean("bookService", BookService.class);

        service.addBook(new Book("101", "Spring in Action"));
        service.addBook(new Book("102", "Spring Boot Essentials"));
System.out.println("🚀 Hello from Library Management!");
        System.out.println("Books Available:");
        service.getAllBooks().forEach(System.out::println);
    }
}
