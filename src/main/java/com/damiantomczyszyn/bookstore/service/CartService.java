package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.entity.Book;
import com.damiantomczyszyn.bookstore.entity.Cart;
import com.damiantomczyszyn.bookstore.entity.CartItems;
import com.damiantomczyszyn.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemService cartItemService;

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;



    public Cart addBooktoCart(Long carttId) {
        return cartItemService.getCartById(carttId);

    }

    public ResponseEntity addBooktoCart(Long booktId, Long carttId) {
        Optional<Book> book = bookService.bookRepository.findById(booktId);
        Optional<Cart> cart = cartRepository.findById(carttId);
        Cart x = new Cart();

        //cartRepository.findBy()



        //dla tego usera
        //znajdz karte
        //i dodaj ksiazke o id jesli istnieje


        return null;
    }
}
