package com.hustarico.adapter;

import com.hustarico.mapper.BookMapper;
import com.hustarico.model.Book;
import com.hustarico.port.BookRepository;
import com.hustarico.repository.SpringDataBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepository {


    private final SpringDataBookRepository springDataBookRepository;



    @Override
    public Book save(Book book) {
        var bookJpaEntity = BookMapper.toInfra(book);
        var persistedJpaEntityBook = springDataBookRepository.save(bookJpaEntity);
        return BookMapper.toDomain(persistedJpaEntityBook);
    }

    @Override
    public List<Book> findAll() {
        return springDataBookRepository.findAll().stream().map(BookMapper::toDomain).toList();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return springDataBookRepository.findById(id).map(BookMapper::toDomain);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return springDataBookRepository.findByTitle(title).map(BookMapper::toDomain);
    }

    @Override
    public Optional<Book> findByAuthor(String author) {
        return springDataBookRepository.findByAuthor(author).map(BookMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        springDataBookRepository.deleteById(id);
    }
}
