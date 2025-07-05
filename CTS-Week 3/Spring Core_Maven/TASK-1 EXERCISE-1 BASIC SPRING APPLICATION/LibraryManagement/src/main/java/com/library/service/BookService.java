package com.library.service;

import java.util.List;
import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository repo) {
        this.bookRepository = repo;
    }

    public List<String> listTitles() {
        return bookRepository.findAllTitles();
    }
}
