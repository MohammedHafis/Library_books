package com.example.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todo.models.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Long> {
}
