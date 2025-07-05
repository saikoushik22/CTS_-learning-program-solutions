package com.example.library.repository;

import java.util.List;

public class BookRepository {
    public List<String> findAll() {
        return List.of("Clean Code", "Effective Java", "Spring in Action");
    }
}
