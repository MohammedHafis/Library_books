package com.example.todo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class BorrowingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Book book;
    @ManyToOne
    private UserRecords user;

    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Boolean isOverdue;
}
