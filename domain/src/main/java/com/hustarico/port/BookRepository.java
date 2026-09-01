package com.hustarico.port;

import com.hustarico.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book save(Book book);
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> findByTitle(String title);
    Optional<Book> findByAuthor(String author);
    void deleteById(Long id);

}
