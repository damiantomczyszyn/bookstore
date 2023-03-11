package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.entity.Book;
import com.damiantomczyszyn.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/books")
    public List<Book> books(){
        return List.of(new Book(),new Book());
    }

    @PostMapping("/addbook")
    public ResponseEntity book(@ModelAttribute Book book){
        bookService.save(book);
        return ResponseEntity.noContent().build();
    }

}
