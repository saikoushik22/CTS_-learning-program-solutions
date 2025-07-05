package com.example.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.library.service.BookService;

public class LibraryApp {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext ctx =
                 new ClassPathXmlApplicationContext("applicationContext.xml")) {

            BookService service = ctx.getBean("bookService", BookService.class);
            service.getAllBooks().forEach(System.out::println);
        }
    }
}