package com.codewithudo.elibrarybooklending.repository;

import com.codewithudo.elibrarybooklending.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    List<BorrowRecord> findByBorrowerName(String borrowerName);
}