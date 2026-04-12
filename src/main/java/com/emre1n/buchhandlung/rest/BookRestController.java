package com.emre1n.buchhandlung.rest;

import com.emre1n.buchhandlung.entity.Book;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
}
