package com.example.library.repository;

import com.example.library.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }
}
