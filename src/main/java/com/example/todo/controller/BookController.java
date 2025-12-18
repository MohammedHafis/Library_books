package com.example.todo.controller;

import com.example.todo.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.todo.service.BookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> listBooks(){
         return ResponseEntity.ok(bookService.listBooks());
    }

    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getbook(id));
    }
}
