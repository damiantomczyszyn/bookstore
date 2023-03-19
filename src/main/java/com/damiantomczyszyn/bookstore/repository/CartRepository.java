package com.damiantomczyszyn.bookstore.repository;


import com.damiantomczyszyn.bookstore.dto.cart.AddToCartDto;
import com.damiantomczyszyn.bookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    public ResponseEntity<String> addtoCart(@RequestBody AddToCartDto addToCartDto,
                                            @RequestParam("token") String token);

}
