package com.hustarico.rest;

import com.hustarico.dto.BorrowBookRequest;
import com.hustarico.dto.CreateBookRequest;
import com.hustarico.model.Book;
import com.hustarico.services.BookService;
import com.hustarico.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody CreateBookRequest createBookRequest) {
        var book = bookService.addBook(
                createBookRequest.title(),
                createBookRequest.author(),
                createBookRequest.yearOfPublication()
        );
        return ResponseEntity.ok(book);
    }

    @PostMapping("/{bookId}/borrow")
    public ResponseEntity<Boolean> borrowBook(@PathVariable(name = "bookId") Long bookId,@RequestBody BorrowBookRequest borrowBookRequest) {
        return ResponseEntity.ok(bookService.borrowBook(borrowBookRequest.userId(),bookId));
    }

    @PostMapping("/{bookId}/return")
    public void returnBook(@PathVariable(name = "bookId") Long bookId){
        bookService.returnBook(bookId);
    }

}
