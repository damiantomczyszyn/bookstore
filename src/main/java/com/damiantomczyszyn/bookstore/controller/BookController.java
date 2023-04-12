package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.entity.Book;

import com.damiantomczyszyn.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class BookController {
    @Autowired
    private BookService bookService;





//-------------------
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/books")
    public List<Book> books(){
        //return List.of(new Book(),new Book());
        return bookService.readAll();
    }

    @PostMapping("/addbook")
    public ResponseEntity book(@RequestBody Book book){
        bookService.save(book);
        return ResponseEntity.created(URI.create("/books")).build();
    }
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") Long bookid)
    {
        bookService.delete(bookid);
    }
    @PutMapping("/books")
    private Book update(@RequestBody Book books)
    {
        bookService.saveOrUpdate(books);
        return books;
    }

}
