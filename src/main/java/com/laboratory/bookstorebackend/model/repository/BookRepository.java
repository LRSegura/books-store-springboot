package com.laboratory.bookstorebackend.model.repository;

import com.laboratory.bookstorebackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
