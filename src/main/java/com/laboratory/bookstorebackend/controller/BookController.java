package com.laboratory.bookstorebackend.controller;

import com.laboratory.bookstorebackend.model.Book;
import com.laboratory.bookstorebackend.model.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/find/all")
    public List<Book> findAll() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public Book createBook(@RequestBody Book book){
        return repository.save(book);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/delete")
    public void deleteBook(@RequestBody Book book){
        repository.delete(book);
    }
}
