package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.entity.Book;
import com.damiantomczyszyn.bookstore.entity.Cart;
import com.damiantomczyszyn.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public void save(Cart cart) {
        cartRepository.save(cart);
    }
    public List<Cart> readAll(){
        if (!cartRepository.findAll().isEmpty()){

            return cartRepository.findAll().stream().toList();
        }
        System.out.println("puste lub nie działa");
        return null;
    }

    public void saveOrUpdate(Cart cart) {
        cartRepository.save(cart);
    }


}
