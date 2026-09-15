package com.hustarico.services;

import com.hustarico.model.Book;
import com.hustarico.model.BookStatus;
import com.hustarico.model.Member;
import com.hustarico.port.BookRepository;
import com.hustarico.port.MemberRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BookService(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }


    public Book save(String title, String author, int yearOfPublication, BookStatus status, Long borrowerId){
        return bookRepository.save(new Book(null, title , author, yearOfPublication ,status , borrowerId));
    }

    //creates new book as available
    public Book addBook(String title, String author, int yearOfPublication){
        return save(title , author, yearOfPublication ,BookStatus.AVAILABLE , null);
    }


    public List<Book> findAll(){
        return bookRepository.findAll();
    }



    public void returnBook(Long bookId){
        var bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()) throw new RuntimeException("Book doesn't exist");

        var book = bookOptional.get();
        if(book.getStatus() != BookStatus.BORROWED) throw new RuntimeException("book aint even borrowed gang");

        var newBook = new Book(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYearOfPublication(),
                BookStatus.AVAILABLE,
                null
        );
        bookRepository.save(newBook);

    }

    public boolean borrowBook(Long memberId, Long bookId){

        var member = memberRepository.findById(memberId);
        if(member.isEmpty()) throw new RuntimeException("member doesn't exist");

        var bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()) throw new RuntimeException("book doesn't exist");


        Book book = bookOptional.get();
        if(book.getStatus() != BookStatus.AVAILABLE){
            return false;
        }

        var newBook = new Book(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYearOfPublication(),
                BookStatus.BORROWED,
                memberId
        );
        bookRepository.save(newBook);
        return true;

    }
}
