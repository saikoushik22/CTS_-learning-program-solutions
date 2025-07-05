
package com.example.library;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {

    private BookService service;

    @BeforeEach
    void setUp() {
        BookRepository repo = new BookRepository();
        service = new BookService();
        service.setBookRepository(repo);
    }

    @Test
    void addAndListBooks() {
        int initial = service.listBooks().size();
        service.addBook(new Book("123", "JUnit In Action", "Third Edition"));
        List<Book> books = service.listBooks();
        assertEquals(initial + 1, books.size());
        assertEquals("JUnit In Action", books.get(books.size() - 1).getTitle());
    }
}
