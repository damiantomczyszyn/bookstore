package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.entity.Book;
import com.damiantomczyszyn.bookstore.entity.CartItem;
import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    public void addBooktoCart(Long bookId, String name) {
        Optional<User> user = userService.userRepository.findByEmail(name);
        if( user.isPresent()){
            System.out.println(user.get().toString());
        }
        //user.get().getCart().addItem();//sprawdz czy nie ma takiego kart itemu z ta ksiazka
        //jesli takiego kartitemu nie ma to go stworz a jesli jest to dodaj ilosc i przelicz cene


        Optional<Book> book = bookService.bookRepository.findById(bookId);
        if(book.isPresent())
        {
            book.get();
        }
    }
}
