package com.damiantomczyszyn.bookstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String price;
    private String author;
    private String publishDate;

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Book(Long id, String name, String price, String author, String publishDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.publishDate = publishDate;
    }

    public Book(Long id, String name, String price, String author, String publishDate, Cart cart) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.publishDate = publishDate;
        this.cart = cart;
    }

    @ManyToOne
    @JoinColumn(name= "cart_id",referencedColumnName="id")
    private Cart cart;

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }
}
