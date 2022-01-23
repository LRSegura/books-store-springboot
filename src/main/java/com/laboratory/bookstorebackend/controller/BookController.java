package com.laboratory.bookstorebackend.controller;

import com.laboratory.bookstorebackend.model.Book;
import com.laboratory.bookstorebackend.model.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @CrossOrigin(origins = "${react.server.path}}")
    @GetMapping("books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @CrossOrigin(origins = "${react.server.path}}")
    @PostMapping("book")
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }
}
