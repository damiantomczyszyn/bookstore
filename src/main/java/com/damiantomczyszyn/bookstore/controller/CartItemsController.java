package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.repository.CartItemsRepository;
import com.damiantomczyszyn.bookstore.service.BookService;
import com.damiantomczyszyn.bookstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class CartItemsController {

    @Autowired
    private CartItemService cartItemService;
}
