package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.entity.Cart;
import com.damiantomczyszyn.bookstore.repository.CartItemsRepository;
import com.damiantomczyszyn.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemService cartItemService;

    public Cart addBooktoCart(Long carttId) {
        return cartItemService.getCartById(carttId);

    }
}
