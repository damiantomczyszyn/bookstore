package com.damiantomczyszyn.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity

public class CartItem {


    public CartItem() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }



    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    private  int quantity;

    public int getQuantity() {
        return quantity;
    }

    public CartItem(Long id, Book book, int quantity, BigDecimal price) {
        this.book = book;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private BigDecimal price;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    @ManyToOne
    Cart cart;

    public CartItem(Book book, int quantity, BigDecimal price) {
        this.book = book;
        this.quantity = quantity;
        this.price = price;
    }

    public CartItem(Long id, Book book, int quantity, BigDecimal price, Cart cart) {
        this.book = book;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
        this.cart = cart;
    }
}
