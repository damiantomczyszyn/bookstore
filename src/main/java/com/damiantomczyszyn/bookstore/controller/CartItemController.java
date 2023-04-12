package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.entity.CartItem;
import com.damiantomczyszyn.bookstore.service.CartItemService;
import com.damiantomczyszyn.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;



}
