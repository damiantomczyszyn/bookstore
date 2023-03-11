package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.entity.Book;
import com.damiantomczyszyn.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;


    public void save(Book book) {
        bookRepository.save(book);
    }
    public List<Book> readAll(){
        if (!bookRepository.findAll().isEmpty())
        return bookRepository.findAll().stream().toList();
        return null;
    }
}
