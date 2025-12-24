package com.example.todo.service;

import com.example.todo.models.Book;
import com.example.todo.models.BorrowingRecord;
import com.example.todo.models.UserRecords;
import com.example.todo.repositories.BookRepository;
import com.example.todo.repositories.BorrowingRecordRepository;
import com.example.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowingService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    public BorrowingRecord borrowing(Long userId, Long bookId) {

        UserRecords user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));

        boolean existingRecord = borrowingRecordRepository.existsByUserIdAndBookIdAndReturnDateIsNull(userId,bookId);
        if (existingRecord){
            throw new RuntimeException("User has already borrowed the book and the book is not returned");
        }

        if (book.getCopiesAvailable() <= 0 ){
            throw new RuntimeException("Book is not available");
        }

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        bookRepository.save(book);

        BorrowingRecord borrow = new BorrowingRecord();
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setBorrowDate(LocalDate.now());
        borrow.setDueDate(LocalDate.now().plusDays(14));
        borrow.setIsOverdue(false);
        return borrowingRecordRepository.save(borrow);
    }

    public void returningBook(Long recordId) {
    BorrowingRecord record = borrowingRecordRepository.findById(recordId).orElseThrow(() ->
            new RuntimeException("Borrow record not found"));

    if (record.getReturnDate() != null){
        throw new RuntimeException("Already returned");
    }
    Book book = record.getBook();
    book.setCopiesAvailable(book.getCopiesAvailable() + 1);
    bookRepository.save(book);

    record.setReturnDate(LocalDate.now());
    record.setIsOverdue(record.getReturnDate().isAfter(record.getDueDate()));
    borrowingRecordRepository.save(record);
    }
}
