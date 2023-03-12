package com.damiantomczyszyn.bookstore.repository;


import com.damiantomczyszyn.bookstore.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Long> {
}
