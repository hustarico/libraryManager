package com.hustarico.mapper;

import com.hustarico.entity.BookJpaEntity;
import com.hustarico.model.Book;

public class BookMapper {

    public static Book toDomain(BookJpaEntity bookJpaEntity){
        return new Book(
                bookJpaEntity.getId(),
                bookJpaEntity.getTitle(),
                bookJpaEntity.getAuthor(),
                bookJpaEntity.getYearOfPublication(),
                bookJpaEntity.getStatus(),
                bookJpaEntity.getBorrowerId()
        );
    }

    public static BookJpaEntity toInfra(Book book){
        return  BookJpaEntity.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .yearOfPublication(book.getYearOfPublication())
                .status(book.getStatus())
                .borrowerId(book.getBorrowerId())
                .build();
    }
}
