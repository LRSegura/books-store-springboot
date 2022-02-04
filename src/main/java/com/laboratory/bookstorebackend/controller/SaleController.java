package com.laboratory.bookstorebackend.controller;

import com.laboratory.bookstorebackend.model.Book;
import com.laboratory.bookstorebackend.model.Sale;
import com.laboratory.bookstorebackend.model.repository.SaleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleRepository repository;

    public SaleController(SaleRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/find/all")
    public List<Sale> findAll() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public Sale createBook(@RequestBody Sale sale){
        return repository.save(sale);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete")
    public void deleteBook(@RequestBody Sale sale){
        repository.delete(sale);
    }
}
