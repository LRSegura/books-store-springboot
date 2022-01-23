package com.laboratory.bookstorebackend.model.repository;

import com.laboratory.bookstorebackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
