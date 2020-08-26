package com.divitngoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divitngoc.dao.BookDao;
import com.divitngoc.generated.tables.pojos.Book;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookDao bookDao;

    @GetMapping("/books")
    public Flux<Book> fetchAllBooks() {
        return bookDao.fetchAllBooks();
    }

    @PostMapping("/books")
    public Mono<Book> insertBook(@RequestBody final Book book) {
        return bookDao.insertBook(book);
    }
}
