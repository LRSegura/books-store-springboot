package com.laboratory.bookstorebackend.model.repository;

import com.laboratory.bookstorebackend.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
