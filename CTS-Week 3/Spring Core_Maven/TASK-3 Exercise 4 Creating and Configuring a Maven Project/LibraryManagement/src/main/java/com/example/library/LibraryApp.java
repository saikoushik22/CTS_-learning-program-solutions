 
package com.example.library;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = ctx.getBean(BookService.class);

        System.out.println("=== Current Library ===");
        service.listBooks().forEach(System.out::println);

        service.addBook(new Book("9781491950357", "Head First Design Patterns", "Eric Freeman"));
        System.out.println("=== After Adding ===");
        service.listBooks().forEach(System.out::println);
    }
}
