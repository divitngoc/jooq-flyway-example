package com.divitngoc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divitngoc.dao.BookDao;
import com.divitngoc.generated.tables.pojos.Book;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookDao bookDao;

    @GetMapping("/books")
    public List<Book> fetchAllBooks() {
        return bookDao.fetchAllBooks();
    }

    @PostMapping("/books")
    public Book insertBook(@RequestBody final Book book) {
        bookDao.insert(book); // Insert returns ID and sets it on Book if ID is AUTOINCREMENT
        return book;
    }
}
