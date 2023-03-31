package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.entity.Cart;
import com.damiantomczyszyn.bookstore.entity.CartItems;
import com.damiantomczyszyn.bookstore.repository.CartItemsRepository;
import com.damiantomczyszyn.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    @Autowired
    CartItemsRepository cartItemsRepository;

    @Autowired
    CartRepository cartRepository;

    public Cart getCartById(Long carttId) {
        return cartRepository.findById(carttId).get();

    }

    public CartItems save(CartItems cartItem) {
        return cartItemsRepository.save(cartItem);
        }
}
