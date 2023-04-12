package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.entity.CartItem;
import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.service.CartItemService;
import com.damiantomczyszyn.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    AuthenticationManager authenticationManager;




    @GetMapping("/additem/{bookId}")
    ResponseEntity addBooktoCart(@PathVariable Long bookId, Authentication authentication){
        System.out.println("Zalogowany User:" + authentication.getName());







        cartItemService.addBooktoCart(bookId,authentication.getName());
        return null;
    }



}
