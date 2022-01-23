package com.laboratory.bookstorebackend.model.repository;

import com.laboratory.bookstorebackend.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer,Long> {
}
