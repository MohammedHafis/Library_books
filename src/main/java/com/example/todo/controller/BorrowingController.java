package com.example.todo.controller;

import com.example.todo.models.BorrowingRecord;
import com.example.todo.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @PostMapping("/borrow")
    public ResponseEntity<BorrowingRecord> borrowBook(@RequestParam Long userId,
                                                      @RequestParam Long bookId){
        BorrowingRecord records = borrowingService.borrowing(userId,bookId);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
    @PutMapping("/return/{recordId}")
    public ResponseEntity<String> returningBook(@PathVariable Long recordId){
        borrowingService.returningBook(recordId);
        return ResponseEntity.ok("Returned Successfully");
    }
}
