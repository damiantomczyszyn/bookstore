package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.repository.CartItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    @Autowired
    CartItemsRepository cartItemsRepository;
}
