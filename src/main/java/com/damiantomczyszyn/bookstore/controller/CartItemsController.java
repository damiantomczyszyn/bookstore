package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.entity.CartItems;
import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.repository.CartItemsRepository;
import com.damiantomczyszyn.bookstore.service.BookService;
import com.damiantomczyszyn.bookstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/v1")
public class CartItemsController {

    @Autowired
    private CartItemService cartItemService;


    @PostMapping("/addcartitem")
    public ResponseEntity user(@RequestBody CartItems cartItems){
        cartItemService.save(cartItems);
        return ResponseEntity.created(URI.create("/cartitems")).build();
    }

}
