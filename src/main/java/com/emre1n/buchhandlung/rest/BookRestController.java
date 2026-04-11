package com.emre1n.buchhandlung.rest;

import com.emre1n.buchhandlung.entity.Book;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private static final Logger log = LoggerFactory.getLogger(BookRestController.class);

    private List<Book> books;

    @PostConstruct
    public void loadData() {

        books = new ArrayList<>();

        books.add(new Book("Die Blechtrommel",
                "Günter Grass",
                "978-3423135409",
                new BigDecimal("16.99")
        ));
        books.add(new Book("Der Vorleser",
                "Bernhard Schlink",
                "978-3257229530",
                new BigDecimal("14.99")
        ));
        books.add(new Book("Der Steppenwolf",
                "Hermann Hesse",
                "978-3518380680",
                new BigDecimal("13.99")
        ));
    }

    @GetMapping("/books")
    public List<Book> getBooks() {

        return books;
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        // to keep it simple for now just index into the list

        // check the bookId against the list size

        if (bookId >= books.size() || bookId < 0) {
            throw new BookNotFoundException("Book id not found - "  + bookId);
        }

        return books.get(bookId);
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException (BookNotFoundException exc) {

        // create a BookErrorResponse

        BookErrorResponse error = new BookErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(Exception exc) {

        // create a BookErrorResponse

        BookErrorResponse error = new BookErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(
                "Please check your input and try again.");
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
