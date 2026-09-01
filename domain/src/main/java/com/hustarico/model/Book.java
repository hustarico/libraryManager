package com.hustarico.model;


public class Book {

    private final Long id;
    private final String title;
    private final String author;
    private final int yearOfPublication;
    private final BookStatus status;
    private final Long borrowerId;


    public Book(Long id, String title, String author, int yearOfPublication, BookStatus status, Long borrowerId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.status = status;
        this.borrowerId = borrowerId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public BookStatus getStatus() {
        return status;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }
}
