package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.entity.Book;
import com.damiantomczyszyn.bookstore.entity.Cart;
import com.damiantomczyszyn.bookstore.service.BookService;
import com.damiantomczyszyn.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class CartController {
    @Autowired
    private CartService cartService;


    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> carts(){
        //return List.of(new Cart(),new Cart());
        return ResponseEntity.ok(cartService.readAll());
    }
    @PostMapping("/addcart")
    public ResponseEntity cart(@RequestBody Cart cart){
        cartService.save(cart);
        return ResponseEntity.created(URI.create("/carts")).build();
    }

    @PutMapping("/updatecart")
    private Cart update(@RequestBody Cart cart)
    {
        cartService.saveOrUpdate(cart);
        return cart;
    }

}
