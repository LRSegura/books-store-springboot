package com.laboratory.bookstorebackend.controller;

import com.laboratory.bookstorebackend.model.Customer;
import com.laboratory.bookstorebackend.model.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/find/all")
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public Customer createCustomer(@RequestBody Customer customer){
        return repository.save(customer);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/delete")
    public void deleteWriter(@RequestBody Customer customer){
        repository.delete(customer);
    }
}


