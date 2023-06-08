package com.damiantomczyszyn.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToMany
    List<Cart> carts;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    User user;


}
