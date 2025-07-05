package com.example.library.service;

import com.example.library.repository.BookRepository;
import java.util.List;

public class BookService {
    private final BookRepository primaryRepository;
    private BookRepository secondaryRepository;

    public BookService(BookRepository primaryRepository) {
        this.primaryRepository = primaryRepository;
    }

    public void setSecondaryRepository(BookRepository secondaryRepository) {
        this.secondaryRepository = secondaryRepository;
    }

    public List<String> listPrimaryBooks() {
        return primaryRepository.findAll();
    }

    public List<String> listSecondaryBooks() {
        return (secondaryRepository != null ? secondaryRepository : primaryRepository).findAll();
    }
}
