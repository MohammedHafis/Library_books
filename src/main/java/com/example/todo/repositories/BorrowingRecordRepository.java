package com.example.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todo.models.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Long> {

    boolean existsByUser_IdAndBook_IdAndReturnDateIsNull(Long userId, Long bookId);

    long countByUser_IdAndReturnDateIsNull(Long userId);
}
