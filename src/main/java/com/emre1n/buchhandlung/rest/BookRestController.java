package com.emre1n.buchhandlung.rest;

import com.emre1n.buchhandlung.entity.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

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
    public Book getBook(@PathVariable("bookId") int bookId) {
        // to keep it simple for now just index into the list

        return books.get(bookId);
    }
}
