package com.example.todo.service;

import com.example.todo.models.Book;
import com.example.todo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Book getbook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
