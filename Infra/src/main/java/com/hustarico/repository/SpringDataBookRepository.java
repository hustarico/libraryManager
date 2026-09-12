package com.hustarico.repository;

import com.hustarico.entity.BookJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataBookRepository extends JpaRepository<BookJpaEntity,Long> {

    Optional<BookJpaEntity> findByTitle(String title);
    Optional<BookJpaEntity> findByAuthor(String author);
}
