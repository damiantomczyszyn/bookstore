package com.damiantomczyszyn.bookstore.repository;

import com.damiantomczyszyn.bookstore.entity.Cart;
import com.damiantomczyszyn.bookstore.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
