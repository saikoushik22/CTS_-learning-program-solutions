 
package com.example.library.repository;

import com.example.library.model.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookRepository {

    private final List<Book> store = new ArrayList<>();

    public BookRepository() {
       
        store.add(new Book("9780132350884", "Clean Code", "Robert C. Martin"));
    }

    public List<Book> findAll() {
        return Collections.unmodifiableList(store);
    }

    public void save(Book book) {
        store.add(book);
    }
}
