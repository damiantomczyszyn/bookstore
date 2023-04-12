package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.repository.CartItemRepository;
import com.damiantomczyszyn.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;

}
