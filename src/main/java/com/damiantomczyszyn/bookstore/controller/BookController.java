package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.entity.Book;
import com.damiantomczyszyn.bookstore.entity.CartItems;
import com.damiantomczyszyn.bookstore.service.BookService;
import com.damiantomczyszyn.bookstore.service.CartItemService;
import com.damiantomczyszyn.bookstore.service.CartService;
import com.damiantomczyszyn.bookstore.service.UserService;
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
    @Autowired
    private UserService userService;
    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartService cartService;


    @PutMapping("/{cartId}/students/{bookId}")
    CartItems addBookToCart(
            @PathVariable Long booktId,
            @PathVariable Long carttId
    ) {
        var cart = cartService.addBooktoCart(carttId);
        var book = bookService.getBooksById(booktId);
        CartItems cartItem= new CartItems(book,cart);
        return cartItemService.save(cartItem);


    }





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
