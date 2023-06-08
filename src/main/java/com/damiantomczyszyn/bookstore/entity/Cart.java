package com.damiantomczyszyn.bookstore.entity;

import jakarta.persistence.*;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import com.damiantomczyszyn.bookstore.entity.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    public void  addItem(CartItem item){
        this.cartItems.add(item);
    }
    public void  removeItem(CartItem item){this.cartItems.remove(item);}

}
